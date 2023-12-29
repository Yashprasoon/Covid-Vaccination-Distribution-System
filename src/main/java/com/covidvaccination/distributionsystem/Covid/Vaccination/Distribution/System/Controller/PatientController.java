package com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Controller;

import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.DTO.GeneralMessageDTO;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.DTO.Request.PatientLoginDTO;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.DTO.Request.PatientSignupDTO;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.DTO.Response.AppointmentDTO;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Exceptions.WrongEmailException;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Exceptions.WrongPasswordException;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Models.Patient;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Service.AppointmentService;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody PatientSignupDTO patientSignupDTO){
         Patient patient = patientService.signup(patientSignupDTO);
         return new ResponseEntity(patient, HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestBody PatientLoginDTO patientLoginDTO){

        try{
            Patient patient = patientService.login(patientLoginDTO);
            return  new ResponseEntity(patient, HttpStatus.CREATED);

        }catch (WrongEmailException wrongEmailException){
            return new ResponseEntity(new GeneralMessageDTO(wrongEmailException.getMessage()), HttpStatus.NOT_FOUND);
        }
        catch (WrongPasswordException wrongPasswordException){
            return new ResponseEntity(new GeneralMessageDTO(wrongPasswordException.getMessage()), HttpStatus.UNAUTHORIZED);
        }

    }

    @GetMapping("/appointment")
    public AppointmentDTO appointment(@RequestParam("email") String email, @RequestParam("vaccinationCenterPreference") String vaccinationCenterPreference){
        return appointmentService.createAppointment(email,vaccinationCenterPreference);
    }




}
