package kz.hackathon.meeting.dto.mappers;


import kz.hackathon.meeting.dto.request.RegistrationDto;
import kz.hackathon.meeting.dto.response.AccountDto;
import kz.hackathon.meeting.models.Account;

public class AccountMapper {
    public static Account fromRequestDto(RegistrationDto dto){
        return Account.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .username(dto.getUsername())
                .role(Account.Role.USER)
                .priority(3)
                .build();
    }

    public static AccountDto toResponseDto(Account account){
        return AccountDto.builder()
                .id(account.getId())
                .email(account.getEmail())
                .username(account.getUsername())
                .build();
    }
}
