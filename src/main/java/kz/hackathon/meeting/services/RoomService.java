package kz.hackathon.meeting.services;

import kz.hackathon.meeting.dto.request.EventDto;
import kz.hackathon.meeting.models.Event;
import kz.hackathon.meeting.models.Room;

import java.util.List;

public interface RoomService extends CrudService<Room, Long> {
    void addScheduleToRoom(Long roomId);
    Event createEvent(EventDto dto);

    void addRoomToOffice(Long officeID, Long roomID);
    List<Room> findAll();

}
