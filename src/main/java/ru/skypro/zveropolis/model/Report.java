package ru.skypro.zveropolis.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String diet;
    private String healthAndAddiction;
    private String behavior;
//    @OneToMany
//    @JoinColumn(name = "user_id")
//    private List<Users> users;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
