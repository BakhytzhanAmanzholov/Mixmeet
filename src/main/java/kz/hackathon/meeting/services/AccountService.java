package kz.hackathon.meeting.services;


import kz.hackathon.meeting.models.Account;
import kz.hackathon.meeting.models.ScheduleRoom;

import java.util.List;

public interface AccountService extends CrudService<Account, Long> {
    Account findByEmail(String email);

    void addAccountToWorkspace(Long accountId, Long workspaceId);

    String isLogged();

    void addEventToAccountOwner(Long accountId, Long eventID);

    void addEventToAccounts(List<Long> accountIds, Long eventID);

    void addOfficeToAccount(Long accountID, Long officeID);

    void calcDep(Account account, Long department);

    List<Account> findAll();
}
