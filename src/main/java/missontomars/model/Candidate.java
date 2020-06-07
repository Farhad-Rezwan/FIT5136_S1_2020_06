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

    /**
     * Constructor
     */
    public Candidate() {
    }

    /**
     * Constructor
     */
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

    /**
     * Get id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id
     * @param id Candidate id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     * @param name candidate name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get date of birth
     * @return date of birth
     */
    public String getDob() {
        return dob;
    }

    /**
     * Set date of birth
     * @param dob date of birth
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * Get city
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Set city
     * @param city candidate city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get postal
     * @return postal
     */
    public String getPostal() {
        return postal;
    }

    /**
     * Set postal
     * @param postal candidate postal
     */
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

    /**
     * Method which display the candidates information
     * @return The display string
     */
    public String displayCandidate() {
        StringBuilder sb = new StringBuilder();
        sb.append(" \n");



        sb.append("Candidate name: " + name + "\n \t");
        sb.append("Candidate DOB: " + dob + "\n \t");
        sb.append("Candidate City: " + city + "\n \t");
        sb.append("Candidate Postal: " + postal + "\n \t");
        sb.append("Candidate Nationality: " + nationality + "\n \t");
        sb.append("Candidate Identification: " + identitification + "\n \t");
        sb.append("Candidate Gender: " + gender + "\n \t");

        sb.append("Candidate Allergies: " );
        for (int i = 0; i < allergies.size(); i++) {
            sb.append(allergies.get(i));
        }

        sb.append("Candidate foodPreference: " );
        for (int i = 0; i < foodPreference.size(); i++) {
            sb.append(foodPreference.get(i));
        }

        sb.append("Candidate Language Preference: " );
        for (int i = 0; i < languagesSpoken.size(); i++) {
            sb.append(languagesSpoken.get(i));
        }

        sb.append("Candidate Work experience: " );
        for (int i = 0; i < workExperience.size(); i++) {
            sb.append(workExperience.get(i));
        }
        sb.append("Candidate qualification: " );
        for (int i = 0; i < qualification.size(); i++) {
            sb.append(qualification.get(i));
        }

        sb.append("Candidate Work experience: " );
        for (int i = 0; i < workExperience.size(); i++) {
            sb.append(workExperience.get(i));
        }

        sb.append("Candidate HealthRecord: " + healthRecord + "\n \t");
        sb.append("Candidate Criminal Record: " + criminalRecord + "\n \t");
        sb.append("Candidate Computer Skill: " + computerSkill + "\n \t");


        return sb.toString();
    }
}
