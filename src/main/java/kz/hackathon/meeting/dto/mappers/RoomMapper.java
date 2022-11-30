package kz.hackathon.meeting.dto.mappers;

import kz.hackathon.meeting.dto.response.*;
import kz.hackathon.meeting.models.Room;
import kz.hackathon.meeting.models.ScheduleRoom;
import kz.hackathon.meeting.models.ScheduleWorkspace;
import kz.hackathon.meeting.models.Workspace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RoomMapper {
    public static RoomWithEventDto toResponseDtoWithEvents(Room room){
        RoomWithEventDto dto = RoomWithEventDto.builder()
                .id(room.getId())
                .room(room.getRoom())
                .capacity(room.getCapacity())
                .title(room.getTitle())
                .type(room.getType().name())
                .events(new ArrayList<>())
                .build();
        List<ScheduleRoomWithEventDto> list = new ArrayList<>();
        for (ScheduleRoom scheduleRoom: room.getSchedule()){
            list.add(ScheduleEventMapper.toResponseDto(scheduleRoom));
//            dto.getEvents().add(ScheduleEventMapper.toResponseDto(scheduleRoom));
        }
        list.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
        dto.setEvents(list);
        return dto;
    }
    public static RoomDto toResponseDto(Room room){
        RoomDto dto = RoomDto.builder()
                .id(room.getId())
                .room(room.getRoom())
                .capacity(room.getCapacity())
                .title(room.getTitle())
                .type(room.getType().name())
                .build();
        return dto;
    }

    public static RoomWithWorkspaceDto toResponseDtoWithWorkspaces(Room room){
        RoomWithWorkspaceDto dto = RoomWithWorkspaceDto.builder()
                .id(room.getId())
                .room(room.getRoom())
                .capacity(room.getCapacity())
                .title(room.getTitle())
                .type(room.getType().name())
                .workspaces(new ArrayList<>())
                .build();
        for (Workspace workspace: room.getWorkspaces()){
            WorkspaceDto workspaceDto = WorkspaceDto.builder()
                    .id(workspace.getId())
                    .schedule(new ArrayList<>())
                    .room(dto.getRoom())
                    .build();
            for (ScheduleWorkspace scheduleWorkspace: workspace.getSchedule()){
                ScheduleWorkspaceDto scheduleWorkspaceDto =  ScheduleWorkspaceDto.builder()
                        .date(String.valueOf(scheduleWorkspace.getDate()))
                        .id(scheduleWorkspace.getId())
                        .build();
                if(scheduleWorkspace.getAccount()!=null){
                    scheduleWorkspaceDto.setAccount(AccountMapper.toResponseDto(scheduleWorkspace.getAccount()));
                }
                workspaceDto.getSchedule().add(scheduleWorkspaceDto);
            }
            dto.getWorkspaces().add(workspaceDto);
        }

        return dto;
    }
}
