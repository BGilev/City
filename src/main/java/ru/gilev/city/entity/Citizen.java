package ru.gilev.city.entity;
import lombok.*;
import org.hibernate.annotations.Cascade;

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

//    * У всех жителей города есть паспорт.
//    * Жители города могут владеть одним/несколькими домами или не владеть вообще. У дома может быть один/несколько хозяев или не быть вообще.
//    * У жителя города может быть одна/несколько машин или не быть вообще, но у машины может быть ровно один хозяин.

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "citizen_name",nullable = false)
    private String name;

    @Column(name = "citizen_surname",nullable = false)
    private String surname;

    @OneToOne
//    @JoinColumn(name = "passport_id",referencedColumnName = "id")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Passport passport;

    @ManyToMany
    @JoinTable(
            name = "citi_house",
            joinColumns = {@JoinColumn(name = "citizen_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "house_id",referencedColumnName = "id")}
    )
    private List<House> houseList = new ArrayList<>();

    @OneToMany(mappedBy = "citizen")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<Car> carList = new ArrayList<>();
}
