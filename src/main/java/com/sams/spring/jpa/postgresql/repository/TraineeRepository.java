package com.sams.spring.jpa.postgresql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sams.spring.jpa.postgresql.model.Trainee;

public interface TraineeRepository extends JpaRepository<Trainee, Long> {
  List<Trainee> findByGender(String gender);

  List<Trainee> findByFirstNameContaining(String firstName);
}