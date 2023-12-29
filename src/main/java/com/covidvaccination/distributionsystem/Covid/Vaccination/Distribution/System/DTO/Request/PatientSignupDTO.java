package com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.DTO.Request;

import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.ENUM.VaccinationPreference;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PatientSignupDTO {

    private String name;
    private String email;
    private String password;
    private long aadharNumber;
    private long phnNum;
    private String gender;
    private String address;
    private int doseCount;
    private VaccinationPreference vaccinationPreference; // enum =['covaxine' , 'covishield' , 'sputnik']
}
