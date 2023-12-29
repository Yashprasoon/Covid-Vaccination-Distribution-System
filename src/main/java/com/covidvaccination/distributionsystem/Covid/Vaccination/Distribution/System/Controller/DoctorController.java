package com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Controller;

import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Models.Doctor;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/register")
    public Doctor register(@RequestBody Doctor doctor){
        return doctorService.registerDoctor(doctor);

    }
}
