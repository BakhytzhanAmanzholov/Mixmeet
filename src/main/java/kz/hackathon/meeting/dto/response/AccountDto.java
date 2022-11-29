package kz.hackathon.meeting.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {
    private Long id;
    private String email;
    private String username;
    private String role;
    private String department;
}
