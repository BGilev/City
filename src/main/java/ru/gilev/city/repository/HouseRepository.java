package ru.gilev.city.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gilev.city.entity.House;

public interface HouseRepository extends JpaRepository<House,Long> {

}
