package main.java.missontomars.control;


import main.java.missontomars.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadMission {

    ArrayList<Mission> missions = new ArrayList<>();

    public ReadMission() {
    }

    public ArrayList<Mission> readMission() {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        SelectionCriteria selectionCriteria = new SelectionCriteria();
        ArrayList<Job> jobList = new ArrayList<>();
        CargoRequirement cargoRequirement = new CargoRequirement();
        ArrayList<CargoRequirement> cargoRequirements = new ArrayList<>();
        ArrayList<EmploymentRequirement> employmentRequirement = new ArrayList<>();
        ArrayList<String> qualificationList = new ArrayList<>();
        ArrayList<Integer> yearList = new ArrayList<>();
        ArrayList<String> occupationList = new ArrayList<>();
        ArrayList<String> languageList = new ArrayList<>();
        ArrayList<String> cargoForList = new ArrayList<>();
        ArrayList<String> cargoRequiredList = new ArrayList<>();
        ArrayList<Integer> quantityList = new ArrayList<>();


        try {

            BufferedReader reader2 = new BufferedReader(new FileReader("mission.csv"));
            reader2.readLine();
            String line;

            while ((line = reader2.readLine()) != null) {
                String[] item = line.split(",");
                StringBuilder line1 = new StringBuilder();
                for (int i = 0; i < item.length; i += 26) {
                    Mission mission = new Mission();
                    mission.setId(Integer.parseInt(item[i]));
                    mission.setMissionName(item[i + 1]);
                    mission.setLaunchDate(fmt.parse(item[i + 2]));
                    mission.setMissionOrigin(item[i + 3]);
                    ArrayList<String> country = new ArrayList<>();
                    String[] s = item[i + 4].split("\\.");
                    country.addAll(Arrays.asList(s));
                    mission.setCountriesAllowed(country);
                    mission.setDuration(Integer.parseInt(item[i + 5]));
                    mission.setMissionType(item[i + 6]);
                    mission.setMissionDescription(item[i + 9]);
                    String[] s3 = item[i+10].split("\\.");
                    String[] s4 = item[i+11].split("\\.");
                    for(int j=0; j<s3.length; j++){
                        EmploymentRequirement employmentRequirement1 = new EmploymentRequirement(Integer.parseInt(s4[j]),s3[j]);
                        employmentRequirement.add(employmentRequirement1);
                    }
                    String[] s1 = item[i + 7].split("\\.");
                    String[] s2 = item[i + 8].split("\\.");
                    for(int j=0; j<s1.length; j++){
                        Job job1 = new Job();
                        job1.setJobName(s1[j]);
                        job1.setJobDescription(s2[j]);
                        jobList.add(job1);
                    }
                    mission.setJob(jobList);
                    mission.setDestinationAddress(item[i+22]);
                    mission.setStatus(item[i+23]);
                    String[] age = item[12].split("-");
                    selectionCriteria.setMaximumAge(Integer.parseInt(age[0]));
                    selectionCriteria.setMinimumAge(Integer.parseInt(age[1]));
                    selectionCriteria.setHealthRecord(item[i+24]);
                    selectionCriteria.setComputerSkill(item[i+16]);
                    selectionCriteria.setCriminalRecord(item[i+25]);
                    String[] qualification = item[14].split("\\.");
                    for(int j=0; j<qualification.length; j++){
                        qualificationList.add(qualification[j]);
                    }
                    String[] minimumYear = item[13].split("\\.");
                    String[] occupation = item[15].split("\\.");
                    for(int j=0; j<occupation.length; j++){
                        yearList.add(Integer.parseInt(minimumYear[j].substring(0,minimumYear[j].length()-2)));
                        occupationList.add(occupation[j]);
                    }
                    selectionCriteria.setExperience(yearList);
                    selectionCriteria.setOccupation(occupationList);
                    String[] language = item[18].split("\\.");
                    languageList.add(item[17]);
                    for(int j=0; j<language.length; j++){
                        languageList.add(language[j]);
                    }
                    selectionCriteria.setLanguageSpoken(languageList);
                    mission.setSelectionCriteria(selectionCriteria);
                    mission.setEmploymentRequirements(employmentRequirement);
                    String[] cargoFor = item[19].split("\\.");
                    for(int j=0; j<cargoFor.length; j++){
                        cargoForList.add(cargoFor[j]);
                    }
                    String[] cargoRequired = item[20].split("\\.");
                    String[] quantity = item[21].split("\\.");
                    for(int j=0; j<cargoRequired.length; j++){
                        cargoRequiredList.add(cargoRequired[j]);
                        quantityList.add(Integer.parseInt(quantity[j]));
                    }
                    cargoRequirement.setCargoFor(cargoForList);
                    cargoRequirement.setCargoRequired(cargoRequiredList);
                    cargoRequirement.setQuantity(quantityList);
                    mission.setCargoRequirement(cargoRequirement);
                    missions.add(mission);
                }
            }
            reader2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return missions;
    }

    public void displayMission(ArrayList<Mission> missions){
        for(int i=0; i<missions.size(); i++){
            System.out.println(missions.get(i).getId());
            System.out.println(missions.get(i).getMissionName());
        }
    }
}
