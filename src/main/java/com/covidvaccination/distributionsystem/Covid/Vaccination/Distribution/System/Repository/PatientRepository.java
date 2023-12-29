package com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Repository;

import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Models.Patient;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Models.VaccinationCenter;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

    @Query(value = "SELECT * FROM patient WHERE email =:email",nativeQuery = true)
    public Patient getPatientByEmail(String email);


    @Query(value = "SELECT * FROM patient WHERE email =:email",nativeQuery = true)
    public Patient getPatientDetailsForAppointment(String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE patient SET dose_count =:patientDoseCount WHERE id =:patientId",nativeQuery = true)
    public void increaseDoseCount(UUID patientId,int patientDoseCount);

    @Query(value = "SELECT dose_count FROM patient WHERE id =:patientId",nativeQuery = true)
    public int getDoseNum(UUID patientId);

}
