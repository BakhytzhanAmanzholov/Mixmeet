package kz.hackathon.meeting.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ScheduleRoom {
//    public enum Weekday {
//        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToOne
    private Account owner;
    @OneToMany
    private List<Account> participants;
    @Enumerated(value = EnumType.STRING)
//    private Weekday weekday;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    @ManyToOne
    private Room room;


}
