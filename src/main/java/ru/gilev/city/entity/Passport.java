package ru.gilev.city.entity;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "passport")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "passport_number", unique = true, nullable = false)
    private String number;

    @OneToOne(mappedBy = "passport")
    private Citizen citizen;




}
