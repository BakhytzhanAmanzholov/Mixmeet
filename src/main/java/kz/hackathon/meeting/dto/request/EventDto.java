package kz.hackathon.meeting.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@Builder
@RequiredArgsConstructor
@Data
public class EventDto {

    public EventDto(String title, Long startId, Long endId, Boolean without, Long[] guestIds) {
        this.title = title;
        this.startId = startId;
        this.endId = endId;
        this.without = without;
        this.guestIds = guestIds;
    }

    private String title;
    private Long startId;
    private Long endId;
    private Boolean without;
    private Long[] guestIds;


}
