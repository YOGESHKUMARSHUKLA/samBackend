package com.sams.spring.jpa.postgresql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sams.spring.jpa.postgresql.model.Trainee;
import com.sams.spring.jpa.postgresql.repository.TraineeRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TraineeController {

    @Autowired
    TraineeRepository traineeRepository;

    @GetMapping("/trainees")
    public ResponseEntity<List<Trainee>> getAllTrainees(@RequestParam(required = false) String title) {
        try {
            List<Trainee> trainee = new ArrayList<Trainee>();

            if (title == null)
                traineeRepository.findAll().forEach(trainee::add);
            else
                traineeRepository.findByFirstNameContaining(title).forEach(trainee::add);

            if (trainee.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(trainee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/trainees/{id}")
    public ResponseEntity<Trainee> getTraineesById(@PathVariable("id") long id) {
        Optional<Trainee> traineeData = traineeRepository.findById(id);

        if (traineeData.isPresent()) {
            return new ResponseEntity<>(traineeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/trainees")
    public ResponseEntity<Trainee> createTrainees(@RequestBody Trainee trainee) {
        try {
            Trainee _trainee = traineeRepository
                    .save(new Trainee(trainee.getSalutation(), trainee.getFirstName(), trainee.getMiddleName(),
                            trainee.getSurName(), trainee.getDateOfBirth(), trainee.getGender(),
                            trainee.getMaritalStatus(), trainee.getCasteCategory()));    //, trainee.getEducationDetails()));
            return new ResponseEntity<>(_trainee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/trainees/{id}")
    public ResponseEntity<Trainee> updateTrainee(@PathVariable("id") long id, @RequestBody Trainee trainee) {
        Optional<Trainee> traineeData = traineeRepository.findById(id);

        if (traineeData.isPresent()) {
            Trainee _trainee = traineeData.get();
            _trainee.setSalutation(trainee.getSalutation());
            _trainee.setFirstName(trainee.getFirstName());
            _trainee.setMiddleName(trainee.getMiddleName());
             _trainee.setSurName(trainee.getSurName());
            _trainee.setDateOfBirth(trainee.getDateOfBirth());
            _trainee.setGender(trainee.getGender());
             _trainee.setMaritalStatus(trainee.getMaritalStatus());
            _trainee.setCasteCategory(trainee.getCasteCategory());
            // _trainee.setEducationDetails(trainee.getEducationDetails());
            return new ResponseEntity<>(traineeRepository.save(_trainee), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/trainees/{id}")
    public ResponseEntity<HttpStatus> deleteTrainee(@PathVariable("id") long id) {
        try {
            traineeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/trainees")
    public ResponseEntity<HttpStatus> deleteAllTraineess() {
        try {
            traineeRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/trainees/published")
    public ResponseEntity<List<Trainee>> findByGender() {
        try {
             List<Trainee> trainee = new ArrayList<Trainee>();

             traineeRepository.findByGender("M").forEach(trainee::add);
            

            if (trainee.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(trainee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
