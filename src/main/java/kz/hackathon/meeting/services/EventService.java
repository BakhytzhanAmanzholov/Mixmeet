package kz.hackathon.meeting.services;

import kz.hackathon.meeting.models.Event;

import java.util.List;

public interface EventService extends CrudService<Event, Long>{
    List<Event> findAll();
}
