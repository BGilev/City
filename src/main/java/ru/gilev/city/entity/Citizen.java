package ru.gilev.city.entity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "citizen")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "citizen_name",nullable = false)
    private String name;

    @Column(name = "citizen_surname",nullable = false)
    private String surname;

    @OneToOne
    @JoinColumn(name = "passport_id",referencedColumnName = "id")
    private Passport passport;

    @ManyToMany
    @JoinTable(
            name = "citi_house",
            joinColumns = {@JoinColumn(name = "citizen_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "house_id",referencedColumnName = "id")}
    )
    private List<House> houseList = new ArrayList<>();

    @OneToMany(mappedBy = "citizen")
    private List<Car> carList = new ArrayList<>();
}
