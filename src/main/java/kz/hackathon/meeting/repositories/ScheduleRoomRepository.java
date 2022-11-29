package kz.hackathon.meeting.repositories;

import kz.hackathon.meeting.models.ScheduleRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRoomRepository extends JpaRepository<ScheduleRoom, Long> {
}
