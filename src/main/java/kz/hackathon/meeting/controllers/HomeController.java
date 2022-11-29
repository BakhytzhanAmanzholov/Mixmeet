package kz.hackathon.meeting.controllers;

import kz.hackathon.meeting.dto.mappers.AccountMapper;
import kz.hackathon.meeting.dto.request.RegistrationDto;
import kz.hackathon.meeting.models.Account;
import kz.hackathon.meeting.services.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class HomeController {
    private final AccountService accountService;


    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody RegistrationDto dto) {
        Account account = AccountMapper.fromRequestDto(dto);
        accountService.calcDep(account, dto.getDepartment());
        account = accountService.save(account);
        accountService.addOfficeToAccount(account.getId(), dto.getOfficeID());

        return ResponseEntity.ok(AccountMapper.toResponseDto(account));
    }
}
