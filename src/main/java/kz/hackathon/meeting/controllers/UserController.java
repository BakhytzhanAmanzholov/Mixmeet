package kz.hackathon.meeting.controllers;

import kz.hackathon.meeting.services.AccountService;
import kz.hackathon.meeting.services.RoomService;
import kz.hackathon.meeting.services.WorkspaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final AccountService accountService;
    private final WorkspaceService workspaceService;
    private final RoomService roomService;


}
