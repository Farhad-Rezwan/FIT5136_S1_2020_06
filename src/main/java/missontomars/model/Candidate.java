package main.java.missontomars.model;

import java.util.List;

public class Candidate {
    private int id;
    private String name;
    private String dob;
    private String city;
    private String postal;
    private String nationality;
    private String identitification;
    private String gender;
    private List<String> allergies;
    private List<String> foodPreference;
    private List<String> qualification;
    private List<String> occupation;
    private List<String> languagesSpoken;
    private List<Integer> workExperience;
    private String healthRecord;
    private String criminalRecord;
    private String computerSkill;

    public Candidate(int id, String name, String dob, String city, String postal, String nationality, String identitification, String gender, List<String> allergies, List<String> foodPreference, List<String> qualification, List<String> occupation, List<String> languagesSpoken, List<Integer> workExperience, String healthRecord, String criminalRecord, String computerSkill) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.city = city;
        this.postal = postal;
        this.nationality = nationality;
        this.identitification = identitification;
        this.gender = gender;
        this.allergies = allergies;
        this.foodPreference = foodPreference;
        this.qualification = qualification;
        this.occupation = occupation;
        this.languagesSpoken = languagesSpoken;
        this.workExperience = workExperience;
        this.healthRecord = healthRecord;
        this.criminalRecord = criminalRecord;
        this.computerSkill = computerSkill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdentitification() {
        return identitification;
    }

    public void setIdentitification(String identitification) {
        this.identitification = identitification;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public List<String> getFoodPreference() {
        return foodPreference;
    }

    public void setFoodPreference(List<String> foodPreference) {
        this.foodPreference = foodPreference;
    }

    public List<String> getQualification() {
        return qualification;
    }

    public void setQualification(List<String> qualification) {
        this.qualification = qualification;
    }

    public List<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(List<String> occupation) {
        this.occupation = occupation;
    }

    public List<String> getLanguagesSpoken() {
        return languagesSpoken;
    }

    public void setLanguagesSpoken(List<String> languagesSpoken) {
        this.languagesSpoken = languagesSpoken;
    }

    public List<Integer> getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(List<Integer> workExperience) {
        this.workExperience = workExperience;
    }

    public String getHealthRecord() {
        return healthRecord;
    }

    public void setHealthRecord(String healthRecord) {
        this.healthRecord = healthRecord;
    }

    public String getCriminalRecord() {
        return criminalRecord;
    }

    public void setCriminalRecord(String criminalRecord) {
        this.criminalRecord = criminalRecord;
    }

    public String getComputerSkill() {
        return computerSkill;
    }

    public void setComputerSkill(String computerSkill) {
        this.computerSkill = computerSkill;
    }
}
