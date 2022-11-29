package kz.hackathon.meeting.dto.mappers;


import kz.hackathon.meeting.dto.response.EventResponseDto;
import kz.hackathon.meeting.models.Account;
import kz.hackathon.meeting.models.ScheduleRoom;

public class EventMapper {

    public static EventResponseDto toRequestDto(ScheduleRoom scheduleRoom) {
        EventResponseDto event = EventResponseDto.builder()
                .id(scheduleRoom.getId())
//                .owner(AccountMapper.toResponseDto(scheduleRoom.getOwner()))
                .title(scheduleRoom.getTitle())
                .startDateTime(String.valueOf(scheduleRoom.getStartDateTime()))
                .endDateTime(String.valueOf(scheduleRoom.getEndDateTime()))
                .build();
        if(scheduleRoom.getOwner()!=null){
            event.setOwner(AccountMapper.toResponseDto(scheduleRoom.getOwner()));
        }
        for (Account account : scheduleRoom.getParticipants()) {
            event.getParticipants().add(AccountMapper.toResponseDto(account));
        }
        event.setRoom(RoomMapper.toResponseDto(scheduleRoom.getRoom()));
        return event;
    }

}
