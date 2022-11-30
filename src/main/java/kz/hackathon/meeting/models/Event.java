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
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToOne
    private Account owner;
    @OneToMany
    @ToString.Exclude
    private List<Account> participants;

    @OneToMany
    private List<ScheduleRoom> schedule;
}
