package kz.hackathon.meeting.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;


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
        USER, ADMIN, MANAGER
    }
    public enum Departament {
        LAWYER, SOFTWARE_ENGINEER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String email;
    private Integer priority;
    @ManyToOne
    private Office office;

    private Boolean confirmed = false;
    private Boolean banned = false;

    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;
    @Enumerated(value = EnumType.STRING)
    private Departament departament;

    @OneToMany
    private List<ScheduleWorkspace> scheduleWorkspaces;

    @ManyToMany
    @ToString.Exclude
    private List<Event> scheduleRooms;
}
