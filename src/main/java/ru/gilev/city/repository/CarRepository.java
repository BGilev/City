package ru.gilev.city.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gilev.city.entity.Car;

public interface CarRepository extends JpaRepository<Car,Long> {
}
