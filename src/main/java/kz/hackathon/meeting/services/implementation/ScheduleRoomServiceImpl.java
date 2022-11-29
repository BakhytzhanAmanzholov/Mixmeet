package kz.hackathon.meeting.services.implementation;

import kz.hackathon.meeting.exceptions.NotFoundException;
import kz.hackathon.meeting.models.ScheduleRoom;
import kz.hackathon.meeting.repositories.ScheduleRoomRepository;
import kz.hackathon.meeting.services.ScheduleRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ScheduleRoomServiceImpl implements ScheduleRoomService {

    private final ScheduleRoomRepository repository;

    @Override
    public ScheduleRoom save(ScheduleRoom entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }

    @Override
    public ScheduleRoom update(ScheduleRoom entity) {
        return null;
    }

    @Override
    public ScheduleRoom findById(Long aLong) {
        return repository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Schedule for room <" + aLong + "> not found"));
    }

    @Override
    public List<ScheduleRoom> findAll() {
        return repository.findAll();
    }
}
