package main.java.missontomars.model;

import java.util.ArrayList;

public class SelectionCriteria {
    private ArrayList<String> qualification;
    private int maximumAge;
    private int minimumAge;
    private ArrayList<Integer> experience;
    private ArrayList<String> occupation;
    private String healthRecord;
    private String criminalRecord;
    private String computerSkill;
    private ArrayList<String> languageSpoken;

    public SelectionCriteria() {
        qualification = new ArrayList<>();
        maximumAge = 0;
        minimumAge = 0;
        experience = new ArrayList<>();
        occupation = new ArrayList<>();
        healthRecord = "";
        criminalRecord = "";
        computerSkill = "";
        languageSpoken = new ArrayList<>();
    }

    public SelectionCriteria(ArrayList<String> qualification,
                             int maximumAge,
                             int minimumAge,
                             ArrayList<Integer> experience,
                             ArrayList<String> occupation,
                             String healthRecord,
                             String criminalRecord,
                             String computerSkill,
                             ArrayList<String> languageSpoken) {
        this.qualification = qualification;
        this.maximumAge = maximumAge;
        this.minimumAge = minimumAge;
        this.experience = experience;
        this.occupation = occupation;
        this.healthRecord = healthRecord;
        this.criminalRecord = criminalRecord;
        this.computerSkill = computerSkill;
        this.languageSpoken = languageSpoken;
    }

    public ArrayList<String> getQualification() {
        return qualification;
    }

    public void setQualification(ArrayList<String> qualification) {
        this.qualification = qualification;
    }

    public int getMaximumAge() {
        return maximumAge;
    }

    public void setMaximumAge(int maximumAge) {
        this.maximumAge = maximumAge;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public ArrayList<Integer> getExperience() {
        return experience;
    }

    public void setExperience(ArrayList<Integer> experience) {
        this.experience = experience;
    }

    public ArrayList<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(ArrayList<String> occupation) {
        this.occupation = occupation;
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

    public ArrayList<String> getLanguageSpoken() {
        return languageSpoken;
    }

    public void setLanguageSpoken(ArrayList<String> languageSpoken) {
        this.languageSpoken = languageSpoken;
    }
}
