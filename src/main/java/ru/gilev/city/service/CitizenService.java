package ru.gilev.city.service;

import ru.gilev.city.dto.CitizenDto;

import java.util.List;

public interface CitizenService {

        void saveUser(CitizenDto citizenDto);

        List<CitizenDto> getByAllCitizen();


        CitizenDto getCitizenById(long id);






}
