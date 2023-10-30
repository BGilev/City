package ru.gilev.city.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "car")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "car_number",nullable = false,unique = true)
    private String number;

    @Column(name = "brand")
    private String brand;

    @ManyToOne
    @JoinColumn(name = "carList",referencedColumnName = "id")
    private Citizen citizen;

}
