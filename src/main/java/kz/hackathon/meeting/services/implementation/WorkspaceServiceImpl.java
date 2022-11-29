package kz.hackathon.meeting.services.implementation;

import kz.hackathon.meeting.exceptions.NotFoundException;
import kz.hackathon.meeting.models.Workspace;
import kz.hackathon.meeting.repositories.WorkspaceRepository;
import kz.hackathon.meeting.services.WorkspaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class WorkspaceServiceImpl implements WorkspaceService {

    private final WorkspaceRepository repository;

    @Override
    public Workspace save(Workspace entity) {
        return repository.save(entity);
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
}
