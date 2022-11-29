package kz.hackathon.meeting.repositories;

import kz.hackathon.meeting.models.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, Long> {
}
