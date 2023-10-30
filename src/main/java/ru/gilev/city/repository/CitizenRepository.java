package ru.gilev.city.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gilev.city.entity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen,Long> {


}
