package kz.hackathon.meeting.dto.mappers;


import kz.hackathon.meeting.dto.request.RegistrationDto;
import kz.hackathon.meeting.dto.response.AccountDto;
import kz.hackathon.meeting.dto.response.ProfileDto;
import kz.hackathon.meeting.dto.response.ScheduleWorkspaceProfileDto;
import kz.hackathon.meeting.models.Account;
import kz.hackathon.meeting.models.ScheduleWorkspace;

import java.util.ArrayList;

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
                .role(account.getRole().name())
                .department(account.getDepartament().name())
                .build();
    }
    public static ProfileDto toResponseDtoProfile(Account account){
        ProfileDto dto = ProfileDto.builder()
                .id(account.getId())
                .email(account.getEmail())
                .username(account.getUsername())
                .role(account.getRole().name())
                .schedule(new ArrayList<>())
                .department(account.getDepartament().name())
                .build();
        for (ScheduleWorkspace scheduleWorkspace: account.getScheduleWorkspaces()){
            dto.getSchedule().add(
              ScheduleWorkspaceProfileDto.builder()
                      .id(scheduleWorkspace.getWorkspace().getId())
                      .date(String.valueOf(scheduleWorkspace.getDate()))
                      .room(RoomMapper.toResponseDto(scheduleWorkspace.getWorkspace().getRoom()))
                      .build()
            );
        }
        return dto;
    }
}
