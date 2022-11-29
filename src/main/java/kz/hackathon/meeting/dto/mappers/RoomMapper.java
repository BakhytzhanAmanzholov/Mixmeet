package kz.hackathon.meeting.dto.mappers;

import kz.hackathon.meeting.dto.response.RoomDto;
import kz.hackathon.meeting.dto.response.RoomWithoutEventDto;
import kz.hackathon.meeting.models.Room;
import kz.hackathon.meeting.models.ScheduleRoom;

import java.util.ArrayList;

public class RoomMapper {
    public static RoomDto toResponseDto(Room room){
        RoomDto dto = RoomDto.builder()
                .id(room.getId())
                .room(room.getRoom())
                .capacity(room.getCapacity())
                .title(room.getTitle())
                .type(room.getType().name())
                .events(new ArrayList<>())
                .build();
        for (ScheduleRoom scheduleRoom: room.getSchedule()){
            dto.getEvents().add(EventMapper.toRequestDto(scheduleRoom));
        }
        return dto;
    }
    public static RoomWithoutEventDto toResponseDtoWith(Room room){
        RoomWithoutEventDto dto = RoomWithoutEventDto.builder()
                .id(room.getId())
                .room(room.getRoom())
                .capacity(room.getCapacity())
                .title(room.getTitle())
                .type(room.getType().name())
                .build();
        return dto;
    }
}
