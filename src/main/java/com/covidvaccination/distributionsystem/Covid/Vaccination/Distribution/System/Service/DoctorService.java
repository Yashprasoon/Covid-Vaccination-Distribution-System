package com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Service;

import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Models.Doctor;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Models.VaccinationCenter;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorService {
    @Autowired
    VaccinationCenterService vaccinationCenterService;
    @Autowired
    DoctorRepository doctorRepository;

//    Doctor will be assigned to VC that has min no of doctors.
    public Doctor registerDoctor(Doctor doctor){
        List<VaccinationCenter> vaccinationCenterList = vaccinationCenterService.getMinDocListVC();
        doctor.setVaccinationCenter(vaccinationCenterList.get(0));
        vaccinationCenterService.updateDocCount(vaccinationCenterList.get(0));
        doctorRepository.save(doctor);
        return doctor;

    }

    public Doctor getDoctorWithLeastPatientCount(){
        return doctorRepository.getDoctorWithLeastPatientCount();
    }

    public void increasePatientCount(UUID doctorID, int patientsCount){
        doctorRepository.increasePatientCount(doctorID,patientsCount);
    }

    public void saveID( UUID doctorID , UUID patientID){
        doctorRepository.saveID(doctorID, patientID);
    }
}



