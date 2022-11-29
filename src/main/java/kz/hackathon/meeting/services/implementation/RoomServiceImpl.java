package kz.hackathon.meeting.services.implementation;

import kz.hackathon.meeting.exceptions.NotFoundException;
import kz.hackathon.meeting.models.Room;
import kz.hackathon.meeting.models.ScheduleRoom;
import kz.hackathon.meeting.repositories.RoomRepository;
import kz.hackathon.meeting.services.RoomService;
import kz.hackathon.meeting.services.ScheduleRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoomServiceImpl implements RoomService {
    private final RoomRepository repository;

    private final ScheduleRoomService scheduleRoomService;

    @Override
    public Room save(Room entity) {
        entity.setWorkspaces(new ArrayList<>());
        entity = repository.save(entity);
        addScheduleToRoom(entity.getId());
        return entity;
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

    @Override
    public void addScheduleToRoom(Long roomId) {
        Room room = findById(roomId);
        if (!room.getType().name().equals(Room.Type.MEETING.name())) {
            return;
        }
        int startH = 7;
        int endH = 7;
        int startM = 0;
        int endM = 30;
        for (int i = 0; i < 30; i++) {
            ScheduleRoom scheduleRoom = scheduleRoomService.save(
              ScheduleRoom.builder()
                      .startDateTime(LocalDateTime.of(2022, 11, 30, startH , startM, 0))
                      .endDateTime(LocalDateTime.of(2022, 11, 30, endH , endM, 0))
                      .participants(new ArrayList<>())
                      .title("")
                      .owner(null)
                      .room(room)
                      .build()
            );
            if(i%2==0){
                endH++;
                startM=30;
                endM=0;
            }
            else {
                startH++;
                startM=0;
                endM=30;
            }
            room.getSchedule().add(scheduleRoom);
            room = findById(roomId);
        }
    }
}
