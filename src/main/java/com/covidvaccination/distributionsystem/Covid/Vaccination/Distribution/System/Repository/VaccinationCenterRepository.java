package com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Repository;

import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Models.VaccinationCenter;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, UUID> {

    @Query(value = "SELECT * FROM `vaccination_center` WHERE `doctor_count` = (SELECT MIN(`doctor_count`) FROM `vaccination_center`)",nativeQuery = true)
    public List<VaccinationCenter> getMinDocVC();

    @Modifying
    @Transactional
    @Query(value = "UPDATE vaccination_center SET doctor_count =:docCount WHERE id =:id",nativeQuery = true)
    public void updateDocCount(int docCount, UUID id);

    @Query(value = "SELECT * FROM `vaccination_center` WHERE type =:type AND sputnik_count != 0 AND patients_count = (SELECT MIN(patients_count) FROM `vaccination_center`)",nativeQuery = true)
    public List<VaccinationCenter> getVaccinationCenterForSputnik(String type);

    @Query(value = "SELECT * FROM `vaccination_center` WHERE type =:type AND covishield_count != 0 AND patients_count = (SELECT MIN(patients_count) FROM `vaccination_center`)",nativeQuery = true)
    public List<VaccinationCenter> getVaccinationCenterForCovishield(String type);

    @Query(value = "SELECT * FROM `vaccination_center` WHERE type =:type AND covaxine_count != 0 AND patients_count = (SELECT MIN(patients_count) FROM `vaccination_center`)",nativeQuery = true)
    public List<VaccinationCenter> getVaccinationCenterForCovaxine(String type);

    @Modifying
    @Transactional
    @Query(value = "UPDATE vaccination_center SET patients_count =:patientsCount WHERE id =:vaccinationCenterID",nativeQuery = true)
    public void increasePatientCount(UUID vaccinationCenterID,int patientsCount);

    @Modifying
    @Query(value = "INSERT INTO vaccination_center_doctor_list (vaccination_center_id,doctor_list_id) VALUES (:vaccinationCenterID, :doctorID)", nativeQuery = true)
    public void saveID(UUID vaccinationCenterID, UUID doctorID);


}
