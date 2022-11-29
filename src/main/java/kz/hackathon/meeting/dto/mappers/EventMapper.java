package kz.hackathon.meeting.dto.mappers;


import kz.hackathon.meeting.dto.request.EventDto;
import kz.hackathon.meeting.dto.response.EventResponseDto;
import kz.hackathon.meeting.models.Account;
import kz.hackathon.meeting.models.ScheduleRoom;

import java.util.ArrayList;

public class EventMapper {

    public static EventResponseDto toRequestDto(ScheduleRoom scheduleRoom) {
        EventResponseDto event = EventResponseDto.builder()
                .id(scheduleRoom.getId())
                .owner(AccountMapper.toResponseDto(scheduleRoom.getOwner()))
                .title(scheduleRoom.getTitle())
                .startDateTime(String.valueOf(scheduleRoom.getStartDateTime()))
                .endDateTime(String.valueOf(scheduleRoom.getEndDateTime()))
                .build();
        for (Account account : scheduleRoom.getParticipants()) {
            event.getParticipants().add(AccountMapper.toResponseDto(account));
        }
        event.setRoom(RoomMapper.toResponseDto(scheduleRoom.getRoom()));
        return event;
    }

    public static ScheduleRoom fromRequestDto(EventDto dto) {
        return ScheduleRoom.builder()
                .title(dto.getTitle())
                .startDateTime(dto.getStartDateTime())
                .endDateTime(dto.getEndDateTime())
                .participants(new ArrayList<>())
                .build();
    }
}
