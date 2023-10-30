package ru.gilev.city.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gilev.city.entity.Passport;

public interface PassportRepository extends JpaRepository<Passport,Long> {
}
