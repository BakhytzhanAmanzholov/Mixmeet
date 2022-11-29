package kz.hackathon.meeting.security.details;

import kz.hackathon.meeting.models.Account;
import kz.hackathon.meeting.repositories.AccountRepository;
import kz.hackathon.meeting.security.config.JwtSecurityConfig;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ConditionalOnBean(value = JwtSecurityConfig.class)
public class UserDetailsServiceImpl implements UserDetailsService {

    AccountRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account user = usersRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User <" + email + "> not found"));

        return new UserDetailsImpl(user);
    }

}

