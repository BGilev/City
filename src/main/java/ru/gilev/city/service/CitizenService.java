package ru.gilev.city.service;

import ru.gilev.city.dto.CitizenDto;
import ru.gilev.city.dto.UserRequest;

import java.util.List;

public interface CitizenService {

        void createCitizen(UserRequest userRequest);

        void saveUser(CitizenDto citizenDto);

        List<CitizenDto> getByAllCitizen();


        CitizenDto getCitizenById(long id);






}
