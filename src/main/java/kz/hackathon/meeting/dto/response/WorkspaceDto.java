package kz.hackathon.meeting.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WorkspaceDto {
    private Long id;
    private String room;
    private List<ScheduleWorkspaceDto> schedule;
}
