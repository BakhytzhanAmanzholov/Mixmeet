package kz.hackathon.meeting.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EventResponseWithoutDto {
    private Long id;
    private String title;
    private AccountDto owner;
    private List<AccountDto> participants;
}
