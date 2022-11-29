package kz.hackathon.meeting.controllers;

import kz.hackathon.meeting.dto.mappers.AccountMapper;
import kz.hackathon.meeting.dto.response.AccountDto;
import kz.hackathon.meeting.models.Account;
import kz.hackathon.meeting.services.AccountService;
import kz.hackathon.meeting.services.RoomService;
import kz.hackathon.meeting.services.WorkspaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<?> getUsers() {
        List<Account> accounts = accountService.findAll();
        List<AccountDto> dtoList = new ArrayList<>();
        for (Account account : accounts) {
            dtoList.add(AccountMapper.toResponseDto(account));
        }

        return ResponseEntity.ok(dtoList);
    }
}
