package main.java.missontomars.control;

import main.java.missontomars.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MissionToMars {
    ArrayList<Mission> listOfMission;
    ArrayList<Shuttle> listOfShuttle;

    public MissionToMars(ArrayList<Mission> listOfMission, ArrayList<Shuttle> listOfShuttle) {
        this.listOfMission = listOfMission;
        this.listOfShuttle = listOfShuttle;
    }


    public static void main(String ...args) {
        System.out.println("hellow form mission to mars");

    }

    public ArrayList<Mission> getListOfMission() {
        return listOfMission;
    }

    public void setListOfMission(ArrayList<Mission> listOfMission) {
        this.listOfMission = listOfMission;
    }

    public ArrayList<Shuttle> getListOfShuttle() {
        return listOfShuttle;
    }

    public void setListOfShuttle(ArrayList<Shuttle> listOfShuttle) {
        this.listOfShuttle = listOfShuttle;
    }



    private void missionCreateMenu(Mission mission) {
        System.out.print("Selected Mission"
                + "\nPress 1 for mission name"
                + "\nPress 2 for mission description"
                + "\nPress 3 for mission origin"
                + "\nPress 4 for countries allowed"
                + "\nPress 5 for launch date"
                + "\nPress 6 for destination address"
                + "\nPress 7 for duration"
                + "\nPress 8 to view mission type"
                + "\nPress 9 for job information"
                + "\nPress 10 for cargo requirement"
                + "\nPress 11 for status of mission"
                + "\nPress 12 for mission overall information"
                + "\nPress 0 to back");
        int select = valueSelect(0, 11);
        if (select == 0) {
            idToEditView();
        } else if (0 < select & select < 12) {
            missionEditMenu(select, mission);
        } else if (select == 12) {
            showOverallInformation(select, mission);
        }
    }

    private void missionEditMenu(int select, Mission mission) {

        if (select == 1) System.out.println(mission.getMissionName());
        else if (select == 2) System.out.println(mission.getMissionDescription());
        else if (select == 3) System.out.println(mission.getMissionOrigin());
        else if (select == 4) {
            for (int i = 0; i < mission.getCountriesAllowed().size(); i++)
                System.out.println((i + 1) + ": " + mission.getCountriesAllowed().get(i));
        } else if (select == 5) System.out.println(mission.getLaunchDate());
        else if (select == 6) {
            for (int i = 0; i < mission.getDestinationAddress().size(); i++)
                System.out.println((i + 1) + ": " + mission.getDestinationAddress().get(i));
        } else if (select == 7) {
            if (mission.getDuration() == 1) System.out.println(mission.getDuration() + " month");
            else System.out.println(mission.getDuration() + " months");
        } else if (select == 8) {
            for (int i = 0; i < mission.getMissionType().size(); i++)
                System.out.println((i + 1) + ": " + mission.getMissionType().get(i));
        } else if (select == 9) {
            for (int i = 0; i < mission.getJob().size(); i++) System.out.println(mission.getJob().get(i));
        } else if (select == 10) mission.getCargoRequirement().displayCargoRequirement();
        else if (select == 11) System.out.println(mission.getStatus());

        int editSelect = inputInt("Press 1 to add" + "\nPress 2 to delete" + "\nPress 0 to go back");
        while (editSelect < 0 || editSelect > 2) {
            editSelect = inputInt("Please select an right option");
        }
        if (editSelect == 1) {

            switch (select) {
                case 1: addMissionName(select, mission); break;
                case 2: addMissionDescription(select, mission); break;
                case 3: addMissionOrigin(select, mission); break;
                case 4: addCountriesAllowed(select, mission); break;
                case 5: addLaunchData(select, mission); break;
                case 6: addDestinationAddress(select, mission); break;
                case 7: addDuration(select, mission); break;
//                case 8: addMissionType(select, mission); break;
                case 9: addJob(select, mission); break;
                case 10: addCargoRequirement(select, mission); break;
                case 11: addStatus(select, mission); break;
            }
        }
    }

    private void addMissionName(int select, Mission mission) {
        System.out.print('\u000C');
        String missionName = inputString("Please insert mission name: ");
        mission.setMissionName(missionName);
        missionEditMenu(select, mission);
    }


    private void addMissionDescription(int select, Mission mission){
        System.out.print('\u000C');
        String description = inputString("Please insert mission description: ");
        mission.setMissionDescription(description);
        missionEditMenu(select, mission);
    }

    private void addMissionOrigin(int select, Mission mission) {
        System.out.print('\u000C');
        String origin = inputString("Please insert mission origin: ");
        mission.setMissionDescription(origin);
        missionEditMenu(select, mission);
    }

    private void addCountriesAllowed(int select, Mission mission) {
        System.out.print('\u000C');
        String country = inputString("Please add the countries allowed");
        ArrayList<String> countries = (ArrayList<String>) mission.getCountriesAllowed();
        countries.add(country);
        mission.setCountriesAllowed(countries);
        missionEditMenu(select, mission);
    }

    private void addLaunchData(int select, Mission mission){
        System.out.print('\u000C');
        String country = inputString("Please add the countries allowed");
        ArrayList<String> countries = (ArrayList<String>) mission.getCountriesAllowed();
        countries.add(country);
        mission.setCountriesAllowed(countries);
        missionEditMenu(select, mission);
    }
    private void addDestinationAddress(int select, Mission mission) {
        System.out.print('\u000C');
        String country = inputString("Please add the destination address");
        ArrayList<String> countries =  mission.getCountriesAllowed();
        countries.add(country);
        mission.setCountriesAllowed(countries);
        missionEditMenu(select, mission);

    }

    private void addDuration(int select, Mission mission) {
        System.out.print('\u000C');
        int duration = inputInt("Please insert duration in months");
        mission.setDuration(duration);
        missionEditMenu(select, mission);
    }

//    private void addMissionType(int select, Mission mission) {
//        System.out.print('\u000C');
//        int duration = inputInt("Please insert duration in months");
//        mission.setDuration(duration);
//        missionEditMenu(select, mission);
//    }

    private void addJob(int select, Mission mission) {

    }

    private void addCargoRequirement(int select, Mission mission){

    }

    private void addStatus(int select, Mission mission) {

    }

    private void showOverallInformation(int select, Mission mission) {

    }

    private void addQualification(int select, SelectionCriteria s) {
        System.out.print('\u000C');
        String qua = inputString("Please add the qualification (only one at a time)");
        ArrayList<String> newQua = s.getQualification();
        newQua.add(qua);
        s.setQualification(newQua);
        missionEditMenu(select, s);
    }



    private void idToEditView() {
        System.out.println("Need Edit: you are in id to edit view");
        System.out.println("Mission 1, Mission 2, mission  3");
        for (int i = 0; i < listOfMission.size(); i++){
            System.out.print((i + 1) + listOfMission.get(i).getMissionName());
        }
        int select = valueSelect(0, 8);

        if (select == 0) {
            idToEditView();
        } else if (0 < select & select < listOfMission.size()) {
            missionCreateMenu(select, s);
        } else if (select == 9) {
            viewAllCre(s);
        }

    }




    private void viewMissionInformation(Mission m) {
        System.out.println("Countries: " +);
        System.out.println();
        System.out.println("years of work experience: " + createWorExp(s));
        System.out.println("occupations: " + createOcc(s));
        System.out.println("health records: " + s.getHealthRecord());
        System.out.println("criminal records: " + s.getCriminalRecord());
        System.out.println("computer skill: " + s.getComputerSkill());
        System.out.println("language spoken: " + createLan(s));
        int back = 1;
        while (back != 0) {
            back = inputInt("Press 0 to go back");
        }
        if (back == 0) {
//            criteriaMenu(s);
        }

    }
    private String displayCountry(SelectionCriteria s) {
        String exp = "";
        for (int i = 0; i < s.getExperience().size(); i++) {
            if (i == 0) {
                exp = String.valueOf(s.getExperience().get(i));
            } else if (i > 0) {
                exp = exp + "," + s.getExperience().get(i);
            }
        }
        return exp;
    }

    private String createOcc(SelectionCriteria s) {
        String occ = "";
        for (int i = 0; i < s.getOccupation().size(); i++) {
            if (i == 0) {
                occ = String.valueOf(s.getOccupation().get(i));
            } else if (i > 0) {
                occ = occ + "," + s.getOccupation().get(i);
            }
        }
        return occ;
    }

    private String createLan(SelectionCriteria s) {
        String lan = "";
        for (int i = 0; i < s.getLanguageSpoken().size(); i++) {
            if (i == 0) {
                lan = String.valueOf(s.getLanguageSpoken().get(i));
            } else if (i > 0) {
                lan = lan + "," + s.getLanguageSpoken().get(i);
            }
        }
        return lan;
    }



    private int inputInt(String displayMessage) {
        boolean notAnInt = true;
        int integer = 0;
        while (notAnInt) {
            Scanner sc = new Scanner(System.in);
            System.out.println(displayMessage);
            //judge whether the input is an int number
            try {
                integer = sc.nextInt();
                notAnInt = false;
            }
            //not an int number
            catch (Exception e) {
                System.out.println("Please enter right options");
            }
        }
        return integer;
    }

    public String inputString(String displayMessage) {
        System.out.println(displayMessage);
        Scanner scan = new Scanner(System.in);
        String temp = scan.nextLine();
        return temp;
    }




    private int valueSelect(int min, int max) {
        int select = -1;
        while (!(min <= select & select <= max)) {
            select = inputInt("Please select an option");
        }
        return select;
    }

    private String createQuaStr(SelectionCriteria s) {
        String str = "";
        for (int i = 0; i < s.getQualification().size(); i++) {
            if (i == 0) {
                str = s.getQualification().get(i);
            } else if (i > 0) {
                str = str + "," + s.getQualification().get(i);
            }
        }
        return str;
    }



}
