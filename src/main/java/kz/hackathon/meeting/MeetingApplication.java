package kz.hackathon.meeting;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.hackathon.meeting.models.Office;
import kz.hackathon.meeting.services.OfficeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class MeetingApplication {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(MeetingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(OfficeService officeService) {
        return args -> {
            Office office = officeService.save(
                    Office.builder()
                            .accounts(new ArrayList<>())
                            .city("Astana")
                            .address("Dostyk 15")
                            .rooms(new ArrayList<>())
                            .title("Main office")
                            .build()
            );
        };
    }
}
