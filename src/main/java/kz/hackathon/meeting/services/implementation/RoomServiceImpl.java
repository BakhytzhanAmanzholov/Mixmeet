package kz.hackathon.meeting.services.implementation;

import kz.hackathon.meeting.exceptions.NotFoundException;
import kz.hackathon.meeting.models.Room;
import kz.hackathon.meeting.repositories.RoomRepository;
import kz.hackathon.meeting.services.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoomServiceImpl implements RoomService {
    private final RoomRepository repository;

    @Override
    public Room save(Room entity) {
        entity.setWorkspaces(new ArrayList<>());
        return repository.save(entity);
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }

    @Override
    public Room update(Room entity) {
        return null;
    }

    @Override
    public Room findById(Long aLong) {
        return repository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Room <" + aLong + "> not found"));
    }
}
