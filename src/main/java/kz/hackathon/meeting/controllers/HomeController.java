package kz.hackathon.meeting.controllers;

import kz.hackathon.meeting.dto.mappers.AccountMapper;
import kz.hackathon.meeting.dto.mappers.OfficeMapper;
import kz.hackathon.meeting.dto.request.RegistrationDto;
import kz.hackathon.meeting.dto.response.OfficeDto;
import kz.hackathon.meeting.exceptions.NotFoundException;
import kz.hackathon.meeting.models.Account;
import kz.hackathon.meeting.models.Office;
import kz.hackathon.meeting.services.AccountService;
import kz.hackathon.meeting.services.OfficeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class HomeController {
    private final AccountService accountService;

    private final OfficeService officeService;


    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody RegistrationDto dto) {
        Account account = AccountMapper.fromRequestDto(dto);
        accountService.calcDep(account, dto.getDepartment());
        account = accountService.save(account);
        try {
            accountService.addOfficeToAccount(account.getId(), dto.getOfficeID());
        }
        catch (NotFoundException e){
            accountService.delete(account.getId());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(AccountMapper.toResponseDto(account));
    }

    @GetMapping("/office")
    public ResponseEntity<?> office(){
        List<Office> offices = officeService.findAll();
        List<OfficeDto> dtoList = new ArrayList<>();
        for (Office office: offices){
            dtoList.add(OfficeMapper.toResponseDto(office));
        }
        return ResponseEntity.ok(dtoList);
    }
}
