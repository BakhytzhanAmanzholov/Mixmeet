package kz.hackathon.meeting.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegistrationDto {
    private String username;
    private String email;
    private String password;
}
