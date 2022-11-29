package kz.hackathon.meeting.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RoomDto {
    private Long id;
    private String title;
    private String room;
    private Integer capacity;
    private String type;
    private List<EventResponseDto> events;
}
