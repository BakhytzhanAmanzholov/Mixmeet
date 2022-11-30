package kz.hackathon.meeting.services.implementation;

import kz.hackathon.meeting.exceptions.NotFoundException;
import kz.hackathon.meeting.models.*;
import kz.hackathon.meeting.repositories.WorkspaceRepository;
import kz.hackathon.meeting.services.AccountService;
import kz.hackathon.meeting.services.RoomService;
import kz.hackathon.meeting.services.ScheduleWorkspaceService;
import kz.hackathon.meeting.services.WorkspaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class WorkspaceServiceImpl implements WorkspaceService {

    private final WorkspaceRepository repository;
    private final ScheduleWorkspaceService scheduleWorkspaceService;

    private final RoomService roomService;

    private final AccountService accountService;


    @Override
    public Workspace save(Workspace entity) {
        entity.setSchedule(new ArrayList<>());
        entity = repository.save(entity);
        for (int i = 0; i < 7; i++) {
            ScheduleWorkspace scheduleWorkspace = scheduleWorkspaceService.save(
                    ScheduleWorkspace.builder()
                            .workspace(entity)
                            .date(LocalDate.of(2022, 12, 1+i))
                            .build()
            );
            entity.getSchedule().add(scheduleWorkspace);
            entity = findById(entity.getId());
        }
        return entity;
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }

    @Override
    public Workspace update(Workspace entity) {
        return null;
    }

    @Override
    public Workspace findById(Long aLong) {
        return repository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Workspace <" + aLong + "> not found"));
    }

    @Override
    public void addWorkspaceToRoom(Long roomId, Long workspaceId) {
        Room room = roomService.findById(roomId);
        Workspace workspace = findById(workspaceId);
        room.getWorkspaces().add(workspace);
        room = roomService.findById(roomId);
        workspace = findById(workspaceId);
        workspace.setRoom(room);
    }

    @Override
    public ScheduleWorkspace addAccountToWorkspace(Long workspaceID) {
        ScheduleWorkspace workspace = scheduleWorkspaceService.findById(workspaceID);
        Account account = accountService.findByEmail(accountService.isLogged());

        Office office = workspace.getWorkspace().getRoom().getOffice();
        int capacityWorkspace = 0;
        int cAccounts = office.getAccounts().size();

        for(Room room: office.getRooms()){
            capacityWorkspace += room.getCapacity();
        }
        capacityWorkspace*=5;

//        if(account.getScheduleWorkspaces().size() >= 3){
//            if(cAccounts*3 )
//        }


        for(ScheduleWorkspace scheduleWorkspace:account.getScheduleWorkspaces()){
            if(scheduleWorkspace.getDate().equals(workspace.getDate())){
                return scheduleWorkspace;
            }
        }
        if(workspace.getAccount()!=null){
            return workspace;
        }

        workspace.setAccount(account);
        workspace = scheduleWorkspaceService.findById(workspaceID);
        account = accountService.findByEmail(accountService.isLogged());
        account.getScheduleWorkspaces().add(workspace);
        return workspace;
    }
}
