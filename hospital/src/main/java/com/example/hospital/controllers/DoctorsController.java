package com.example.hospital.controllers;

import com.example.hospital.entities.Doctor;
import com.example.hospital.services.DoctorsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class DoctorsController {
    private final DoctorsService doctorsService;

    @GetMapping("/doctors")
    public String findAll(Model model){
        List<Doctor> doctors = doctorsService.findAll();
        model.addAttribute("doctors", doctors );
        return "doctors-list";
    }

    @GetMapping("/doctor-create")
    public String createDoctorForm(Doctor doctor){
        return "doctor-create";
    }

    @PostMapping("/doctor-create")
    public String createDoctor(Doctor doctor){
        doctorsService.createDoctor(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/doctor-delete/{id}")
    public String deleteDoctor(@PathVariable Integer id){
        doctorsService.deleteById(id);
        return "redirect:/doctors";
    }

    @GetMapping("/doctor-update/{id}")
    public String updateDoctorForm(@PathVariable("id") Integer id, Model model){
        Doctor doctor = doctorsService.findById(id);
        model.addAttribute("doctor", doctor);
        return "doctor-update";
    }
    @PostMapping("/doctor-update")
    public String updateDoctor(Doctor doctor){
        doctorsService.createDoctor(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/doctor-patients/{id}")
    public String showPatientsByDoctor(@PathVariable Integer id, Model model){
        Doctor doctor = doctorsService.findById(id);
        model.addAttribute("doctor", doctor);
        return "doctor-patients";
    }
}
