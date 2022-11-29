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
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String city;
    private String address;
    @OneToMany
    @ToString.Exclude
    private List<Account> accounts;
    @OneToMany
    @ToString.Exclude
    private List<Room> rooms;
}
