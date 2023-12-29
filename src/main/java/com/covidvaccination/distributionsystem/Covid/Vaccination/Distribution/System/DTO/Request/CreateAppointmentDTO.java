package com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.DTO.Request;

import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.ENUM.VaccinationCenterPreference;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CreateAppointmentDTO {
    private String name;
    private long aadharNumber;
    private String vaccinePreference;
    private VaccinationCenterPreference vaccinationCenterPreference;

}
