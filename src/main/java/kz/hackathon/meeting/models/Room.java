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
public class Room {

    public enum Type {
        MEETING, OPEN_SPACE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String room;
    private Integer capacity;
    @ManyToOne
    private Office office;
    @OneToMany
    @ToString.Exclude
    private List<Workspace> workspaces;
    @Enumerated(value = EnumType.STRING)
    private Type type;
}
