package kz.hackathon.meeting.services;

import kz.hackathon.meeting.models.ScheduleWorkspace;
import kz.hackathon.meeting.models.Workspace;

public interface WorkspaceService extends CrudService<Workspace, Long>{
    void addWorkspaceToRoom(Long roomId, Long workspaceId);

    ScheduleWorkspace addAccountToWorkspace(Long workspaceID);
}
