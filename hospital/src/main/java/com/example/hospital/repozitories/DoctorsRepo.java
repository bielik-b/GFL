package com.example.hospital.repozitories;

import com.example.hospital.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsRepo extends JpaRepository<Doctor, Integer> {
}
