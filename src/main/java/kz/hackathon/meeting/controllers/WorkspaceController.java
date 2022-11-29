package kz.hackathon.meeting.controllers;

import kz.hackathon.meeting.dto.mappers.ScheduleWorkspaceMapper;
import kz.hackathon.meeting.services.WorkspaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/workspace")
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    @PostMapping("/{id}")
    public ResponseEntity<?> schedule(@PathVariable Long id){
        return ResponseEntity.ok(ScheduleWorkspaceMapper.toResponseDto(workspaceService.addAccountToWorkspace(id)));
    }
}
