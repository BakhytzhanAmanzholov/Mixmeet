package kz.hackathon.meeting.models;

import jakarta.persistence.*;
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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    @ManyToOne
    private Workspace workspace;
    @ManyToOne
    private Account account;
}
