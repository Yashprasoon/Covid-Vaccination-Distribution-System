package com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Repository;

import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Models.Doctor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {


    @Query(value = "SELECT * FROM `doctor` WHERE `patient_count` = (SELECT MIN(`patient_count`) FROM `doctor`)",nativeQuery = true)
    public Doctor getDoctorWithLeastPatientCount();

    @Modifying
    @Transactional
    @Query(value = "UPDATE doctor SET patient_count =:patientsCount WHERE id =:doctorID",nativeQuery = true)
    public void increasePatientCount(UUID doctorID,int patientsCount);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO doctor_patient_list (doctor_id , patient_list_id) VALUES (?1, ?2)", nativeQuery = true)
    public void saveID(UUID doctorID, UUID patientID);

}
