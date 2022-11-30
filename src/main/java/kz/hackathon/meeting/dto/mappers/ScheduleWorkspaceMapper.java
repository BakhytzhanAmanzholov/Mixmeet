package kz.hackathon.meeting.dto.mappers;

import kz.hackathon.meeting.dto.response.ScheduleWorkspaceDto;
import kz.hackathon.meeting.models.ScheduleWorkspace;

public class ScheduleWorkspaceMapper {
    public static ScheduleWorkspaceDto toResponseDto(ScheduleWorkspace scheduleWorkspace){
        ScheduleWorkspaceDto dto = ScheduleWorkspaceDto.builder()
                .id(scheduleWorkspace.getId())
                .date(String.valueOf(scheduleWorkspace.getDate()))
//                .account(AccountMapper.toResponseDto(scheduleWorkspace.getAccount()))
                .build();
        if(scheduleWorkspace.getAccount()!=null){
            dto.setAccount(AccountMapper.toResponseDto(scheduleWorkspace.getAccount()));
        }
        return dto;
    }
}
