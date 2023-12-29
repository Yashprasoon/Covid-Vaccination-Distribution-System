package com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String gender;
    private int doseCount;
    @Column(unique = true)
    private long aadharNumber;
    private String vaccinationPreference;
    private String address;
    @Column(unique = true)
    private long phnNumber;
    @Column(unique = true)
    private String email;
    private String password;

}
