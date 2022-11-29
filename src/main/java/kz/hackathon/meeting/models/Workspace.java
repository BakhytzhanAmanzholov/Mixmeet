package kz.hackathon.meeting.models;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Room room;
    @OneToMany
    @ToString.Exclude
    private List<ScheduleWorkspace> schedule;

}
