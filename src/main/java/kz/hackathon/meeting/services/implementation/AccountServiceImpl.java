package kz.hackathon.meeting.services.implementation;

import kz.hackathon.meeting.models.*;
import kz.hackathon.meeting.repositories.AccountRepository;
import kz.hackathon.meeting.services.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;
    private final PasswordEncoder passwordEncoder;

    private final ScheduleRoomService scheduleRoomService;

    private final ScheduleWorkspaceService scheduleWorkspaceService;

    private final OfficeService officeService;

    @Override
    public Account findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User <" + email + "> not found"));
    }

    @Override
    public Account save(Account entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        entity.setBanned(true);
        entity.setConfirmed(true);
        entity.setState(Account.State.CONFIRMED);
        entity.setScheduleRooms(new ArrayList<>());
        return repository.save(entity);
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }

    @Override
    public Account update(Account entity) {
        Account account = findById(entity.getId());
        account.setUsername(entity.getUsername());
        return account;
    }

    @Override
    public Account findById(Long aLong) {
        return repository.findById(aLong).orElseThrow(
                () -> new UsernameNotFoundException("User <" + aLong + "> not found"));
    }

    @Override
    public void addAccountToWorkspace(Long accountId, Long workspaceId) {
        Account account = findById(accountId);
        ScheduleWorkspace workspace = scheduleWorkspaceService.findById(workspaceId);

        workspace.setAccount(account);
        account = findById(accountId);
        workspace = scheduleWorkspaceService.findById(workspaceId);
        account.getScheduleWorkspaces().add(workspace);
    }

    @Override
    public String isLogged() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        log.info(currentPrincipalName);
        if (!currentPrincipalName.equals("anonymousUser")) {
            return currentPrincipalName;
        }
        return "anonymousUser";
    }

    @Override
    public void addEventToAccountOwner(Long accountId, Long eventID) {
        Account account = findById(accountId);
        ScheduleRoom event = scheduleRoomService.findById(eventID);
        event.setOwner(account);
    }

    @Override
    public void addEventToAccounts(List<Long> accountIds, Long eventID) {
        ScheduleRoom event = scheduleRoomService.findById(eventID);

        for(Long id: accountIds){
            Account account = findById(id);
            event.getParticipants().add(account);
            event = scheduleRoomService.findById(eventID);
            account = findById(id);
            account.getScheduleRooms().add(event);
        }
    }

    @Override
    public void addOfficeToAccount(Long accountID, Long officeID) {
        Account account = findById(accountID);
        Office office = officeService.findById(officeID);
        account.setOffice(office);
        account = findById(accountID);
        office = officeService.findById(officeID);
        office.getAccounts().add(account);
    }

    @Override
    public void calcDep(Account account, Long department) {
        if (department == 0) {
            account.setDepartament(Account.Departament.LAWYER);

            account.setDepartament(Account.Departament.SOFTWARE_ENGINEER);
        } else if (department == 1) {
            account.setDepartament(Account.Departament.SOFTWARE_ENGINEER);
        }
    }

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }
}
