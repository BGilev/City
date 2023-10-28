package ru.gilev.city.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gilev.city.entity.Citizen;
import ru.gilev.city.model.CitizenRequest;
import ru.gilev.city.model.CitizenResponse;
import ru.gilev.city.service.CitizenService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/citizen")
public class CitizenController {

    private final CitizenService citizenService;

    @Autowired
    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitizenResponse> getCitizenById(@PathVariable ("id") long id){
        CitizenResponse citizenResponse = citizenService.getCitizensById(id);

        return new ResponseEntity<>(citizenResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Citizen>> getAllCitizen(){
        List<Citizen> citizens = citizenService.getAllCitizens();
        return new ResponseEntity<>(citizens,HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Long> addCitizen(@RequestBody CitizenRequest citizenRequest){
        long citizenId = citizenService.addCitizen(citizenRequest);

        return new ResponseEntity<>(citizenId,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByCitizen(@PathVariable("id") long id){
        citizenService.deleteByCitizen(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
