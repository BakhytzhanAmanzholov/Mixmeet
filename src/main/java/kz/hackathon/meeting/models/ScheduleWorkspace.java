package kz.hackathon.meeting.models;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ScheduleWorkspace {
//    public enum Weekday {
//                Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
//    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    @ManyToOne
    private Workspace workspace;
    @ManyToOne
    private Account account;
//    private Weekday weekday;

}
