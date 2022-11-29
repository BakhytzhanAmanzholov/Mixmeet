package kz.hackathon.meeting.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Account {

    public enum State {
        NOT_CONFIRMED, CONFIRMED, DELETED, BANNED
    }

    public enum Role {
        USER, ADMIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String email;
    private Integer priority;

    private Boolean confirmed = false;
    private Boolean banned = false;

    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;
}
