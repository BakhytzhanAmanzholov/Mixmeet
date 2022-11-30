package kz.hackathon.meeting.repositories;

import kz.hackathon.meeting.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
