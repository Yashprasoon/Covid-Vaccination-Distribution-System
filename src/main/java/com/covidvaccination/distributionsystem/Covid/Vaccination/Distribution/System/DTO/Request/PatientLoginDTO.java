package com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.DTO.Request;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PatientLoginDTO {

    private String email;
    private String password;
}
