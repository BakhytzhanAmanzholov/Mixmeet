package kz.hackathon.meeting.services.implementation;

import kz.hackathon.meeting.exceptions.NotFoundException;
import kz.hackathon.meeting.models.Office;
import kz.hackathon.meeting.models.Room;
import kz.hackathon.meeting.repositories.OfficeRepository;
import kz.hackathon.meeting.services.OfficeService;
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
public class OfficeServiceImpl implements OfficeService {
    private final OfficeRepository repository;

    private final RoomService roomService;

    @Override
    public Office save(Office entity) {
        entity.setRooms(new ArrayList<>());
        return repository.save(entity);
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }

    @Override
    public Office update(Office entity) {
        return null;
    }

    @Override
    public Office findById(Long aLong) {
        return repository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Office <" + aLong + "> not found"));
    }

    @Override
    public void addRoomToOffice(Long officeID, Long roomID) {
        Room room = roomService.findById(roomID);
        Office office = findById(officeID);
        room.setOffice(office);
        room = roomService.findById(roomID);
        office = findById(officeID);
        office.getRooms().add(room);
    }
}
