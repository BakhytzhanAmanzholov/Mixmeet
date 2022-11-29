package kz.hackathon.meeting.services;

import kz.hackathon.meeting.models.ScheduleRoom;

import java.util.List;

public interface ScheduleRoomService extends CrudService<ScheduleRoom, Long> {
    List<ScheduleRoom> findAll();
}
