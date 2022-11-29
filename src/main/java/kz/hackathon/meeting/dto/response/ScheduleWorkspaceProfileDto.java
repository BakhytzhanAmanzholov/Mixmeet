package kz.hackathon.meeting.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScheduleWorkspaceProfileDto {
    private Long id;
    private String date;
    private RoomDto room;
}
