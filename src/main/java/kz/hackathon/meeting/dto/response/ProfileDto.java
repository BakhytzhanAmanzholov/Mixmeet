package kz.hackathon.meeting.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class ProfileDto {
    private Long id;
    private String email;
    private String username;
    private String role;
    private List<ScheduleWorkspaceProfileDto> schedule;
}
