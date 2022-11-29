package kz.hackathon.meeting.services;

import kz.hackathon.meeting.dto.request.EventDto;
import kz.hackathon.meeting.models.Room;
import kz.hackathon.meeting.models.ScheduleRoom;

public interface RoomService extends CrudService<Room, Long> {
    void addScheduleToRoom(Long roomId);
    ScheduleRoom createEvent(EventDto dto);

    void addRoomToOffice(Long officeID, Long roomID);
}
