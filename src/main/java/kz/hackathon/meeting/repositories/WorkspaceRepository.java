package kz.hackathon.meeting.repositories;

import kz.hackathon.meeting.models.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
}
