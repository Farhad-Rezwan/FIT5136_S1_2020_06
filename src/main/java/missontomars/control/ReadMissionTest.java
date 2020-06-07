package main.java.missontomars.control;

import main.java.missontomars.model.Mission;
import main.java.missontomars.model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadMissionTest {
    public static void main(String... args) {
        ReadMission readMission = new ReadMission();
        ArrayList<Mission> missions = readMission.readMission();
        readMission.displayMission(missions);
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select the mission id");
        String missionId = sc.nextLine();
        sc.close();
        for(int i=0; i<missions.size(); i++){
            if(Integer.toString(missions.get(i).getId()).equals(missionId)){
                System.out.println(missions.get(i).getId());
                System.out.println(missions.get(i).getMissionName());
                System.out.println(missions.get(i).getLaunchDate());
                System.out.println(missions.get(i).getMissionOrigin());
                String countries = "";
                for(int j=0; j<missions.get(i).getCountriesAllowed().size(); j++){
                    countries = countries + missions.get(i).getCountriesAllowed().get(j) +" ";
                }
                System.out.println(countries);
                System.out.println(missions.get(i).getDuration());
                System.out.println(missions.get(i).getMissionType());
                System.out.println(missions.get(i).getJob());
                System.out.println(missions.get(i).getMissionDescription());
                System.out.println(missions.get(i).getEmploymentRequirements());
                System.out.println(missions.get(i).getSelectionCriteria());
                System.out.println(missions.get(i).getCargoRequirement());
                System.out.println(missions.get(i).getDestinationAddress());
                System.out.println(missions.get(i).getStatus());
            }
        }
    }
}
