package com.example.hospital.services;

import com.example.hospital.entities.Patient;
import com.example.hospital.repozitories.PatientsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientsService {
    PatientsRepo patientsRepo;

    public Patient createPatient(Patient patient) {
        return patientsRepo.save(patient);
    }

    public void deleteById(Integer id){
        patientsRepo.deleteById(id);
    }

    public Patient findById(Integer id) {
        return patientsRepo.getOne(id);
    }
}
