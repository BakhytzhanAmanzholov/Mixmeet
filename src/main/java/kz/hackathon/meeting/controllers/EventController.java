package kz.hackathon.meeting.controllers;

import kz.hackathon.meeting.dto.mappers.AccountMapper;
import kz.hackathon.meeting.dto.mappers.EventMapper;
import kz.hackathon.meeting.dto.request.EventDto;
import kz.hackathon.meeting.dto.request.RegistrationDto;
import kz.hackathon.meeting.dto.response.EventResponseDto;
import kz.hackathon.meeting.models.Account;
import kz.hackathon.meeting.models.ScheduleRoom;
import kz.hackathon.meeting.services.AccountService;
import kz.hackathon.meeting.services.RoomService;
import kz.hackathon.meeting.services.ScheduleRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class EventController {

    private final AccountService accountService;
    private final ScheduleRoomService scheduleRoomService;
    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody EventDto dto) {
        ScheduleRoom scheduleRoom = EventMapper.fromRequestDto(dto);
        if (!dto.getWithout()) {
            scheduleRoom.setOwner(accountService.findByEmail(accountService.isLogged()));
        }
        for (Long id : dto.getGuestIds()) {
            scheduleRoom.getParticipants().add(accountService.findById(id));
        }
        scheduleRoom.setRoom(roomService.findById(dto.getRoomID()));

        scheduleRoom = scheduleRoomService.save(scheduleRoom);

        return ResponseEntity.ok(EventMapper.toRequestDto(scheduleRoom));
    }

    @GetMapping
    public ResponseEntity<?> events() {
        List<ScheduleRoom> events = scheduleRoomService.findAll();
        List<EventResponseDto> dtoList = new ArrayList<>();
        for (ScheduleRoom event : events) {
            dtoList.add(EventMapper.toRequestDto(event));
        }
        return ResponseEntity.ok(dtoList);
    }
}
