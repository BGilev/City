package ru.gilev.city.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "CITIZEN")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Citizen {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CITIZEN_ID")
    private long id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "SURNAME",nullable = false)
    private String surname;

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }


}
