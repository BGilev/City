package ru.gilev.city.service.Iml;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gilev.city.entity.Citizen;
import ru.gilev.city.exception.CitizenCustomException;
import ru.gilev.city.model.CitizenRequest;
import ru.gilev.city.model.CitizenResponse;
import ru.gilev.city.repository.CitizenRepository;
import ru.gilev.city.service.CitizenService;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@RequiredArgsConstructor
public class CitizenServiceImpl implements CitizenService {

    private final CitizenRepository citizenRepository;


    @Override
    public CitizenResponse getCitizensById(long id) {
        Citizen citizen = citizenRepository.findById(id)
                .orElseThrow(()->
                        new CitizenCustomException("Citizen with given id not found","Citizen not found" ));

        CitizenResponse citizenResponse = new CitizenResponse();

        copyProperties(citizen,citizenResponse);

        return citizenResponse;
    }

    @Override
    public long addCitizen(CitizenRequest citizenRequest) {
        Citizen citizen = Citizen.builder()
                .name(citizenRequest.getName())
                .surname(citizenRequest.getSurname())
                .build();

        citizenRepository.save(citizen);

        return citizen.getId();
    }

    @Override
    public List<Citizen> getAllCitizens() {
        return citizenRepository.findAll();
    }

    @Override
    public void deleteByCitizen(long id) {
        citizenRepository.deleteById(id);
    }
}
