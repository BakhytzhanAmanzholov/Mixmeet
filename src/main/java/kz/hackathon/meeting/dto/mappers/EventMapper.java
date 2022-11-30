package kz.hackathon.meeting.dto.mappers;


import kz.hackathon.meeting.dto.response.EventResponseDto;
import kz.hackathon.meeting.dto.response.EventResponseWithoutDto;
import kz.hackathon.meeting.dto.response.ScheduleRoomDto;
import kz.hackathon.meeting.models.Account;
import kz.hackathon.meeting.models.Event;
import kz.hackathon.meeting.models.ScheduleRoom;

import java.util.ArrayList;

public class EventMapper {

    public static EventResponseDto toRequestDto(Event event) {
        EventResponseDto eventDto = EventResponseDto.builder()
                .id(event.getId())
                .title(event.getTitle())
                .participants(new ArrayList<>())
                .schedule(new ArrayList<>())
                .build();
        if(event.getOwner()!=null){
            eventDto.setOwner(AccountMapper.toResponseDto(event.getOwner()));
        }
        for (Account account : event.getParticipants()) {
            eventDto.getParticipants().add(AccountMapper.toResponseDto(account));
        }
        for (ScheduleRoom scheduleRoom: event.getSchedule()){
            if(scheduleRoom.getEvent() != null){
                eventDto.getSchedule().add(
                        ScheduleRoomDto.builder()
                                .room(RoomMapper.toResponseDto(scheduleRoom.getRoom()))
                                .startDateTime(String.valueOf(scheduleRoom.getStartDateTime()))
                                .endDateTime(String.valueOf(scheduleRoom.getEndDateTime()))
                                .build()
                );
            }
        }
        return eventDto;
    }

    public static EventResponseWithoutDto toResponseDtoWithout(Event event){
        EventResponseWithoutDto eventDto = EventResponseWithoutDto.builder()
                .id(event.getId())
                .title(event.getTitle())
                .participants(new ArrayList<>())
                .build();
        if(event.getOwner()!=null){
            eventDto.setOwner(AccountMapper.toResponseDto(event.getOwner()));
        }
        for (Account account : event.getParticipants()) {
            eventDto.getParticipants().add(AccountMapper.toResponseDto(account));
        }
        return eventDto;
    }

}
