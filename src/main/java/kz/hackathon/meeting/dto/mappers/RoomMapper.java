package kz.hackathon.meeting.dto.mappers;

import kz.hackathon.meeting.dto.response.RoomDto;
import kz.hackathon.meeting.models.Room;

public class RoomMapper {
    public static RoomDto toResponseDto(Room room){
        return RoomDto.builder()
                .id(room.getId())
                .room(room.getRoom())
                .capacity(room.getCapacity())
                .title(room.getTitle())
                .type(room.getType().name())
                .build();
    }
}
