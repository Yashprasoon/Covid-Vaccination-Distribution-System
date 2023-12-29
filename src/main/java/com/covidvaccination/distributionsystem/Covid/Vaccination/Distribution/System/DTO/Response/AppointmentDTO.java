package com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.DTO.Response;

import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Models.Doctor;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Models.Patient;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Models.VaccinationCenter;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AppointmentDTO {

    int doseNum;
    Patient patient;
    Doctor doctor;
    VaccinationCenter vaccinationCenter;
}
