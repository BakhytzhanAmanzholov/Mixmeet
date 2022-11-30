package kz.hackathon.meeting.controllers;

import kz.hackathon.meeting.dto.mappers.ScheduleWorkspaceMapper;
import kz.hackathon.meeting.dto.response.ScheduleWorkspaceDto;
import kz.hackathon.meeting.models.ScheduleWorkspace;
import kz.hackathon.meeting.services.WorkspaceService;
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
@RequestMapping("/api/workspace")
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    @PostMapping("/{id}")
    public ResponseEntity<?> schedule(@PathVariable Long id) {
        ScheduleWorkspace workspace = workspaceService.addAccountToWorkspace(id);
        if (workspace == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(ScheduleWorkspaceMapper.toResponseDto(workspace));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSchedule(@PathVariable("id") Long id){
        List<ScheduleWorkspace> scheduleWorkspaces = workspaceService.findById(id).getSchedule();
        List<ScheduleWorkspaceDto> dtoList = new ArrayList<>();
        for (ScheduleWorkspace scheduleWorkspace: scheduleWorkspaces){
            dtoList.add(ScheduleWorkspaceMapper.toResponseDto(scheduleWorkspace));
        }

        return ResponseEntity.ok(dtoList);
    }
}
