package kz.hackathon.meeting.repositories;

import kz.hackathon.meeting.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
