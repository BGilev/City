package ru.gilev.city.entity;

import javax.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


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
    @Column(name = "house_street",nullable = false)
    private String street;


    @ManyToMany(mappedBy = "houseList")
    private List<Citizen> citizenList = new ArrayList<>();
}
