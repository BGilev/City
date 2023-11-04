package ru.gilev.city.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gilev.city.dto.UserRequest;
import ru.gilev.city.service.CitizenService;

@RestController
@RequestMapping("/api/v1")
//@RequiredArgsConstructor
public class CitizenController {

    private final CitizenService citizenService;

    @Autowired
    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @PostMapping("/citizen")
    public ResponseEntity<Void> createCitizen(@RequestBody UserRequest userRequest){
        citizenService.createCitizen(userRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
