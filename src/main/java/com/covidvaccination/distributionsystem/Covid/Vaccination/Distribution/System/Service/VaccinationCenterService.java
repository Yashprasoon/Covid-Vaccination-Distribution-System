package com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Service;

import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Models.VaccinationCenter;
import com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VaccinationCenterService {
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    public VaccinationCenter register(VaccinationCenter vaccinationCenter){
        return vaccinationCenterRepository.save(vaccinationCenter);
    }

    public List<VaccinationCenter> getMinDocListVC(){
        return vaccinationCenterRepository.getMinDocVC();
    }

    public void updateDocCount(VaccinationCenter vaccinationCenter){
        vaccinationCenterRepository.updateDocCount(vaccinationCenter.getDoctorCount()+1,vaccinationCenter.getId());
    }

    public List<VaccinationCenter> getVaccinationCenterByType(String vaccinationCenterPreference,String vaccinationPreference){
        VaccinationCenter vaccinationCenter;
        if( vaccinationPreference.equals("Sputnik")){
            return vaccinationCenterRepository.getVaccinationCenterForSputnik(vaccinationCenterPreference);
        }
        else if( vaccinationPreference.equals("Covishield")){
           return vaccinationCenterRepository.getVaccinationCenterForCovishield(vaccinationCenterPreference);
        }
        else {
            return vaccinationCenterRepository.getVaccinationCenterForCovaxine(vaccinationCenterPreference);
        }

    }

    public void increasePatientCount(UUID vaccinationCenterID, int patientsCount){
        vaccinationCenterRepository.increasePatientCount(vaccinationCenterID,patientsCount);
    }

    public void saveID(UUID vaccinationCenterID, UUID doctorID){
        vaccinationCenterRepository.saveID(vaccinationCenterID, doctorID);
    }
}