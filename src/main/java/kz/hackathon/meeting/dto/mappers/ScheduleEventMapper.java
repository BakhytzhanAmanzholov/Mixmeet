package kz.hackathon.meeting.dto.mappers;

import kz.hackathon.meeting.dto.response.ScheduleRoomWithEventDto;
import kz.hackathon.meeting.models.ScheduleRoom;

public class ScheduleEventMapper {
    public static ScheduleRoomWithEventDto toResponseDto(ScheduleRoom scheduleRoom){
        ScheduleRoomWithEventDto dto = ScheduleRoomWithEventDto.builder()
                .id(scheduleRoom.getId())
                .startDateTime(String.valueOf(scheduleRoom.getStartDateTime()))
                .endDateTime(String.valueOf(scheduleRoom.getEndDateTime()))

                .build();
        if(scheduleRoom.getEvent()!=null){
            dto.setEvent(EventMapper.toResponseDtoWithout(scheduleRoom.getEvent()));
        }
        return dto;
    }
}
