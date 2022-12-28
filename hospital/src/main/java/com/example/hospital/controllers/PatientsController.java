package com.example.hospital.controllers;

import com.example.hospital.entities.Doctor;
import com.example.hospital.entities.Patient;
import com.example.hospital.services.PatientsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class PatientsController {
    PatientsService patientsService;

    @GetMapping("/patients-create")
    public String createPatientForm(Patient patient){
        return "/patients-create";
    }

    @PostMapping("/patients-create")
    public String createPatient(Patient patient){
        patientsService.createPatient(patient);
        return "redirect:/doctor-patients";
    }

    @GetMapping("/patients-delete/{id}")
    public String deletePatient(@PathVariable Integer id){
        patientsService.deleteById(id);
        return "redirect:/doctor-patients";
    }

    @GetMapping("/patients-update/{id}")
    public String updatePatientForm(@PathVariable("id") Integer id, Model model){
        Patient patient = patientsService.findById(id);
        model.addAttribute("patients", patient);
        return "patients-update";
    }
    @PostMapping("/patients-update")
    public String updatePatient(Patient patient){
        patientsService.createPatient(patient);
        return "redirect:/doctor-patients";
    }
}
