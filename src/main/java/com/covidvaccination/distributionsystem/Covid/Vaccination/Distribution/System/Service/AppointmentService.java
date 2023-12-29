package com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Service;

import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.DTO.GeneralMessageDTO;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.DTO.Response.AppointmentDTO;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Models.Doctor;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Models.Patient;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Models.VaccinationCenter;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {


    @Autowired
    PatientRepository patientRepository;

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;

    @Autowired
    MailService mailService;


    public AppointmentDTO createAppointment(String email, String vaccinationCenterPreference) {

        Patient patient = patientRepository.getPatientDetailsForAppointment(email);
        String vaccinationPreference = patient.getVaccinationPreference();
        List<VaccinationCenter> vaccinationCenterList = vaccinationCenterService.getVaccinationCenterByType(vaccinationCenterPreference, vaccinationPreference);
        VaccinationCenter vaccinationCenter = vaccinationCenterList.get(0);
        Doctor doctor = doctorService.getDoctorWithLeastPatientCount();
        UUID doctorID = doctor.getId();
        UUID vaccinationCenterID = vaccinationCenter.getId();
        vaccinationCenterService.increasePatientCount(vaccinationCenterID,vaccinationCenter.getPatientsCount()+1);
        doctorService.increasePatientCount(doctorID,doctor.getPatientCount()+1);
        doctorService.saveID(doctorID, patient.getId());
        patientService.increaseDoseCount(patient.getId(),patient.getDoseCount()+1);

        String to = patient.getEmail();
        String subject = String.format("Congrats !! %s You have been registered. ",patient.getName());
        String text = String.format("Hi %s,\n" +
                "Your appointment got created. Below are your appointment details :\n" +
                "1. Dose count : %d\n" +
                "2. Doctor Name : %s \n" +
                "3. Vaccination center name : %s\n" +
                "4. Vaccination center address : %s",
                patient.getName(),
                patient.getDoseCount(),
                doctor.getName(),
                vaccinationCenter.getName(),
                vaccinationCenter.getAddress()
                );

        mailService.generateMail(to,subject,text);

        return new AppointmentDTO(patientService.getDoseNum(patient.getId()), patient, doctor , vaccinationCenter);


    }
}
