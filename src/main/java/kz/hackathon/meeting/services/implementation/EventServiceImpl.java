package kz.hackathon.meeting.services.implementation;

import kz.hackathon.meeting.exceptions.NotFoundException;
import kz.hackathon.meeting.models.Event;
import kz.hackathon.meeting.repositories.EventRepository;
import kz.hackathon.meeting.services.CrudService;
import kz.hackathon.meeting.services.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    @Override
    public Event save(Event entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }

    @Override
    public Event update(Event entity) {
        return null;
    }

    @Override
    public Event findById(Long aLong) {
        return repository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Event <" + aLong + "> not found"));
    }

    @Override
    public List<Event> findAll() {
        return repository.findAll();
    }
}
