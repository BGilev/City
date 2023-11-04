package ru.gilev.city.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gilev.city.dto.CitizenDto;
import ru.gilev.city.dto.UserRequest;
import ru.gilev.city.entity.Citizen;
import ru.gilev.city.entity.Passport;
import ru.gilev.city.exception.CitizenCustomException;
import ru.gilev.city.mappers.CitizenMapper;
import ru.gilev.city.repository.CitizenRepository;
import ru.gilev.city.service.CitizenService;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CitizenServiceImpl implements CitizenService {

    private final CitizenRepository citizenRepository;

    private final CitizenMapper citizenMapper;


    @Transactional
    @Override
    public void createCitizen(UserRequest userRequest) {
        Citizen citizen = citizenMapper.toEntity(userRequest);
        citizen.setPassport(createPassport());
        citizenRepository.save(citizen);
    }

    @Override
    public void saveUser(CitizenDto citizenDto) {

        Citizen citizen = citizenMapper.dtoToEntity(citizenDto);
//        Citizen citizen = Citizen.builder()
//                .id(citizenDto.getId())
//                .name(citizenDto.getName())
//                .surname(citizenDto.getSurname())
//                .passport(citizenDto.getPassport())
//                .houseList(citizenDto.getHouseList())
//                .carList(citizenDto.getCarList())
//                .build();
        citizenRepository.save(citizen);
    }


    @Override
    public List<CitizenDto> getByAllCitizen() {
        List<Citizen> citizen = citizenRepository.findAll();
        return citizen.stream()
                .map(citizenMapper::entityToDto)
                .collect(Collectors.toList());

    }

    @Override
    public CitizenDto getCitizenById(long id) {
        Citizen citizen = citizenRepository.findById(id)
                .orElseThrow(()->
                        new CitizenCustomException("Citizen not found", HttpStatus.NOT_FOUND.toString()));

        return citizenMapper.entityToDto(citizen);
    }

    public Passport createPassport() {
        return Passport.builder()
                .number(UUID.randomUUID().toString())
                .build();
    }

}
