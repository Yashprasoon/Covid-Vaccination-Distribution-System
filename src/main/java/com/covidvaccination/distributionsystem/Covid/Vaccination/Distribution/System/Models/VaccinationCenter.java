package com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String type;
    private int covaxineCount;
    private int covishieldCount;
    private int sputnikCount;
    private int doctorCount;
    private int patientsCount;
    private String address;
    @OneToMany
    private List<Doctor> doctorList;


    public VaccinationCenter(){

    }

    public VaccinationCenter(UUID id, String name, String type, int covaxineCount, int covishieldCount, int sputnikCount, int doctorCount, int patientsCount, String address, List<Doctor> doctorList) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.covaxineCount = covaxineCount;
        this.covishieldCount = covishieldCount;
        this.sputnikCount = sputnikCount;
        this.doctorCount = doctorCount;
        this.patientsCount = patientsCount;
        this.address = address;
        this.doctorList = doctorList;

    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCovaxineCount() {
        return covaxineCount;
    }

    public void setCovaxineCount(int covaxineCount) {
        this.covaxineCount = covaxineCount;
    }

    public int getCovishieldCount() {
        return covishieldCount;
    }

    public void setCovishieldCount(int covishieldCount) {
        this.covishieldCount = covishieldCount;
    }

    public int getSputnikCount() {
        return sputnikCount;
    }

    public void setSputnikCount(int sputnikCount) {
        this.sputnikCount = sputnikCount;
    }

    public int getDoctorCount() {
        return doctorCount;
    }

    public void setDoctorCount(int doctorCount) {
        this.doctorCount = doctorCount;
    }

    public int getPatientsCount() {
        return patientsCount;
    }

    public void setPatientsCount(int patientsCount) {
        this.patientsCount = patientsCount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
