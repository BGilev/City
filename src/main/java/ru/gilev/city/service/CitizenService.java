package ru.gilev.city.service;

import ru.gilev.city.entity.Citizen;
import ru.gilev.city.model.CitizenRequest;
import ru.gilev.city.model.CitizenResponse;

import java.util.List;

public interface CitizenService {

    CitizenResponse getCitizensById(long id);

    long addCitizen(CitizenRequest citizenRequest);

    List<Citizen> getAllCitizens();

    void deleteByCitizen(long id);


}
