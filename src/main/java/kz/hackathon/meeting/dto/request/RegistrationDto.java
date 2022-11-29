package kz.hackathon.meeting.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class RegistrationDto {
    private String username;
    private String email;
    private String password;
    private Long officeID;
    private Long department;
}
