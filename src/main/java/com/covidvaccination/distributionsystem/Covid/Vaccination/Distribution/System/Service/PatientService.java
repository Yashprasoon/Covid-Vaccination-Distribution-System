package com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Service;

import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.DTO.Request.PatientLoginDTO;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.DTO.Request.PatientSignupDTO;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Exceptions.WrongEmailException;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Exceptions.WrongPasswordException;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Models.Patient;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Patient signup(PatientSignupDTO patientSignupDTO){

        Patient patient = new Patient();
        patient.setName(patientSignupDTO.getName());
        patient.setGender(patientSignupDTO.getGender());
        patient.setEmail(patientSignupDTO.getEmail());
        patient.setAddress(patientSignupDTO.getAddress());
        patient.setDoseCount(patientSignupDTO.getDoseCount());
        patient.setPassword(patientSignupDTO.getPassword());
        patient.setPhnNumber(patientSignupDTO.getPhnNum());
        patient.setVaccinationPreference(patientSignupDTO.getVaccinationPreference().toString());
        patient.setAadharNumber(patientSignupDTO.getAadharNumber());
        return patientRepository.save(patient);

    }

    public Patient login(PatientLoginDTO patientLoginDTO){

        Patient patient = patientRepository.getPatientByEmail(patientLoginDTO.getEmail());

        if(patient == null){
            throw new WrongEmailException("Patient Email ID not registered.");
        }

        if(!patient.getPassword().equals(patientLoginDTO.getPassword())){
            throw new WrongPasswordException("Incorrect Password.");
        }

        return  patient;
    }

    public void increaseDoseCount(UUID patientId,int patientDoseCount){
        patientRepository.increaseDoseCount(patientId, patientDoseCount);
    }

    public int getDoseNum(UUID patientId){
        return patientRepository.getDoseNum(patientId);
    }
}
