package kz.hackathon.meeting.controllers;

import kz.hackathon.meeting.dto.mappers.EventMapper;
import kz.hackathon.meeting.dto.mappers.RoomMapper;
import kz.hackathon.meeting.dto.response.EventResponseDto;
import kz.hackathon.meeting.models.Room;
import kz.hackathon.meeting.models.ScheduleRoom;
import kz.hackathon.meeting.services.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;

    @GetMapping("/{id}")
    public ResponseEntity<?> room(@PathVariable("id") Long id) {
        Room room = roomService.findById(id);
        return ResponseEntity.ok(RoomMapper.toResponseDto(room));
    }
}
