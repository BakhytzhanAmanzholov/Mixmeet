package kz.hackathon.meeting.repositories;

import kz.hackathon.meeting.models.ScheduleWorkspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleWorkspaceRepository extends JpaRepository<ScheduleWorkspace, Long> {
}
