package ru.skypro.zveropolis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
//@NoArgsConstructor
//@Builder
//@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private boolean withLimitedOpportunities;
    @Enumerated(EnumType.STRING)
    private TypeOfAnimal typeOfAnimal;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
}
