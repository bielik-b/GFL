package com.example.hospital.repozitories;

import com.example.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepo extends JpaRepository<Patient, Integer> {
}
