package kz.hackathon.meeting.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScheduleRoomWithEventDto {
    private Long id;
    private String startDateTime;
    private String endDateTime;
    private EventResponseWithoutDto event;

}
