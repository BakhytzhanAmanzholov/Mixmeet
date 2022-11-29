package kz.hackathon.meeting.services;


import kz.hackathon.meeting.models.Account;

public interface AccountService extends CrudService<Account, Long> {
    Account findByEmail(String email);
}
