package com.example.hospital.services;

import com.example.hospital.entities.Doctor;
import com.example.hospital.repozitories.DoctorsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorsService {
     private final DoctorsRepo doctorsRepo;

     public List<Doctor> findAll(){
          return doctorsRepo.findAll();
     }

     public Doctor createDoctor(Doctor doctor){
          return doctorsRepo.save(doctor);
     }

     public void deleteById(Integer id){
          doctorsRepo.deleteById(id);
     }

     public Doctor findById(Integer id) {
          return doctorsRepo.getOne(id);
     }
}

