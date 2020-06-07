package main.java.missontomars.model;

import java.util.ArrayList;
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
    private ArrayList<String> allergies;
    private ArrayList<String> foodPreference;
    private ArrayList<String> qualification;
    private ArrayList<String> occupation;
    private ArrayList<String> languagesSpoken;
    private ArrayList<Integer> workExperience;
    private String healthRecord;
    private String criminalRecord;
    private String computerSkill;

    public Candidate() {
    }

    public Candidate(int id, String name, String dob, String city, String postal, String nationality, String identitification, String gender, ArrayList<String> allergies, ArrayList<String> foodPreference, ArrayList<String> qualification, ArrayList<String> occupation, ArrayList<String> languagesSpoken, ArrayList<Integer> workExperience, String healthRecord, String criminalRecord, String computerSkill) {
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

    public ArrayList<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(ArrayList<String> allergies) {
        this.allergies = allergies;
    }

    public ArrayList<String> getFoodPreference() {
        return foodPreference;
    }

    public void setFoodPreference(ArrayList<String> foodPreference) {
        this.foodPreference = foodPreference;
    }

    public ArrayList<String> getQualification() {
        return qualification;
    }

    public void setQualification(ArrayList<String> qualification) {
        this.qualification = qualification;
    }

    public ArrayList<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(ArrayList<String> occupation) {
        this.occupation = occupation;
    }

    public ArrayList<String> getLanguagesSpoken() {
        return languagesSpoken;
    }

    public void setLanguagesSpoken(ArrayList<String> languagesSpoken) {
        this.languagesSpoken = languagesSpoken;
    }

    public ArrayList<Integer> getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(ArrayList<Integer> workExperience) {
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
