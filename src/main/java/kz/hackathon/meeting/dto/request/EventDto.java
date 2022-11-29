package kz.hackathon.meeting.dto.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EventDto {
    private String title;
    private Long officeID;
    private Long roomID;
    private Long[] guestIds;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Boolean without;
}
