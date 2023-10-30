package ru.gilev.city.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "house")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "house_numder",nullable = false)
    private String number;


    @ManyToMany(mappedBy = "houseSet")
    private List<Citizen> citizenSet = new ArrayList<>();
}
