package kz.hackathon.meeting.services.implementation;

import kz.hackathon.meeting.models.Account;
import kz.hackathon.meeting.repositories.AccountRepository;
import kz.hackathon.meeting.services.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;
    private final PasswordEncoder passwordEncoder;

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
}
