package ru.gilev.city.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.gilev.city.entity.Car;
import ru.gilev.city.entity.House;
import ru.gilev.city.entity.Passport;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
@Setter
public class CitizenDto {

    private long id;
    private String name;
    private String surname;
    private Passport passport; // will be generated in service
    private List<House> houseList;
    private List<Car> carList;
}
