package kz.hackathon.meeting.services.implementation;

import kz.hackathon.meeting.exceptions.NotFoundException;
import kz.hackathon.meeting.models.ScheduleWorkspace;
import kz.hackathon.meeting.repositories.ScheduleWorkspaceRepository;
import kz.hackathon.meeting.services.ScheduleWorkspaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ScheduleWorkspaceImpl implements ScheduleWorkspaceService {

    private final ScheduleWorkspaceRepository repository;

    @Override
    public ScheduleWorkspace save(ScheduleWorkspace entity) {
        

        return repository.save(entity);
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }

    @Override
    public ScheduleWorkspace update(ScheduleWorkspace entity) {
        return null;
    }

    @Override
    public ScheduleWorkspace findById(Long aLong) {
        return repository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Schedule for workspace <" + aLong + "> not found"));
    }
}
