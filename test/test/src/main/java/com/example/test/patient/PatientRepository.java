package com.example.test.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, String> {
    List<Patient> findByIdContainingOrFirstnameContainingOrLastnameContaining(String key, String key1, String key2);
}

