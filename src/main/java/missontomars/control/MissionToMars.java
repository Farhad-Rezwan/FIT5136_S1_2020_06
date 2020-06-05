package main.java.missontomars.control;

import main.java.missontomars.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MissionToMars {
    ArrayList<Mission> listOfMission;
    ArrayList<Shuttle> listOfShuttle;
    String userType;


    public MissionToMars(ArrayList<Mission> listOfMission, ArrayList<Shuttle> listOfShuttle) {
        this.listOfMission = listOfMission;
        this.listOfShuttle = listOfShuttle;
    }

    public MissionToMars () {

    }




    public static void login() {

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



    public void missionCreateMenu(Mission mission) {
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
                + "\nPress 0 to back"
                + "\n");
        int select = valueSelect(0, 12);
        if (select == 0) {
            idToEditView();
        } else if (0 < select & select < 12) {
            missionEditMenu(select, mission);
        } else if (select == 12) {
            showOverallInformation(mission);
        }
    }

    private void missionEditMenu(int select, Mission mission) {

        System.out.println(displayHeader(select, mission));

        int editSelect = inputInt("Press 1 to add" + "\nPress 2 to delete" + "\nPress 0 to go back");
        while (editSelect < 0 || editSelect > 2) {
            editSelect = inputInt("Please select an right option");
        }

        if (editSelect == 0) {
            missionCreateMenu(mission);
        }

        if (editSelect == 1) {
            System.out.println(displayHeader(select, mission));
            addEntries(select, mission);
        }

        if (editSelect == 2) {
            deleteEntries(select, mission);
        }

        System.out.println(displayHeader(select, mission));
    }

    private String displayHeader(int select, Mission mission) {

        StringBuilder str = new StringBuilder();
        System.out.print('\u000C');


        switch (select) {
            case 1:
                if (null != mission.getMissionName())
                    str.append("Mission name is set to: " + mission.getMissionName());
                else
                    str.append("There is no mission name set");
                break;
            case 2:
                if (null != mission.getMissionDescription())
                    str.append("Mission description: " + mission.getMissionDescription());
                else
                    str.append("There is no mission discription set");
                break;
            case 3:
                if (null != mission.getMissionOrigin())
                    str.append("Mission origin: " + mission.getMissionOrigin());
                else
                    str.append("There is no mission origin set");
                break;
            case 4:
                if (null != mission.getCountriesAllowed()){
                    for (int i = 0; i < mission.getCountriesAllowed().size(); i++)
                        str.append((i + 1) + ": " + mission.getCountriesAllowed().get(i));
                } else {
                    str.append("There is no countries allowed set");
                }
                break;
            case 5:
                if (null != mission.getLaunchDate())
                    str.append("Mission launch date: " + mission.getLaunchDate());
                else {
                    str.append("Mission launch date is not set");
                }
                break;
            case 6:
                if (null != mission.getDestinationAddress())
                    str.append("Mission destination address: " + mission.getDestinationAddress());
                else
                    str.append("There is no launch date set...");
                break;
            case 7:
                if (mission.getDuration() > 0)
                    str.append(mission.getDuration() + " month");
                else
                    str.append("There is no duration set for the mission");
                break;
            case 8:
                if (null != mission.getMissionType()) {
                    str.append("Mission type is set to ");
                } else {
                    str.append("Start from here");
                }
                break;
            case 9:
                if (true) str.append(mission.getCargoRequirement().displayCargoRequirement() + " month");
                else str.append(mission.getDuration() + " months");
                break;
            case 10:
                if (null != mission.getJob()) {
                    for (int i = 0; i < mission.getJob().size(); i++)
                        str.append(mission.getJob().get(i).getJobName());
                } else
                    str.append("There is no cargo requirement set");
                break;
            case 11:
                if (null != mission.getStatus())
                    str.append("The mission status is :" + mission.getStatus());
                else {
                    str.append("Mission status is not set");
                }
                break;

        }
        return str.toString();
    }


    private void addEntries(int select, Mission mission) {

        switch (select) {
            case 1:
                addMissionName(select, mission);
                break;
            case 2:
                addMissionDescription(select, mission);
                break;
            case 3:
                addMissionOrigin(select, mission);
                break;
            case 4:
                addCountriesAllowed(select, mission);
                break;
            case 5:
                addLaunchData(select, mission);
                break;
            case 6:
                addDestinationAddress(select, mission);
                break;
            case 7:
                addDuration(select, mission);
                break;
//                case 8: addMissionType(select, mission); break;
            case 9:
                addJob(select, mission);
                break;
            case 10:
                addCargoRequirement(select, mission);
                break;
            case 11:
                addStatus(select, mission);
                break;
        }
    }

    // 1.
    private void addMissionName(int select, Mission mission) {
        System.out.print('\u000C');
        String missionName = inputString("Please insert mission name: ");
        mission.setMissionName(missionName);
        missionEditMenu(select, mission);
    }

    private void idToEditView() {
        int numberOfMission = listOfMission.size();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numberOfMission; i++) {
            sb.append((i + 1) + "： " + listOfMission.get(i).getMissionName() + "\n");
        }
        System.out.println(sb.toString());

        int missionSelect = inputInt("Select mission number to edit", sb.toString());
        while (missionSelect < 1 || missionSelect > numberOfMission) {
            System.out.println(" ");
            System.out.println(sb.toString());
            missionSelect = inputInt("Please choose the right option", sb.toString());

        }

        missionCreateMenu(listOfMission.get(missionSelect - 1));
        System.out.println("Selected");

    }

    // 2.
    private void addMissionDescription(int select, Mission mission){
        System.out.print('\u000C');
        String description = inputString("Please insert mission description: ");
        mission.setMissionDescription(description);
        missionEditMenu(select, mission);
    }

    // 3.
    private void addMissionOrigin(int select, Mission mission) {
        System.out.print('\u000C');
        String origin = inputString("Please insert mission origin: ");
        mission.setMissionDescription(origin);
        missionEditMenu(select, mission);
    }

    // 4.
    private void addCountriesAllowed(int select, Mission mission) {
        System.out.print('\u000C');
        String country = inputString("Please add the countries allowed");
        ArrayList<String> countries = (ArrayList<String>) mission.getCountriesAllowed();
        countries.add(country);
        mission.setCountriesAllowed(countries);
        missionEditMenu(select, mission);
    }

    // 5.
    private void addLaunchData(int select, Mission mission){
        System.out.print('\u000C');
        mission.setLaunchDate(insertDate("Please enter proper launch date"));
        missionEditMenu(select, mission);
    }

    // 6.
    private void addDestinationAddress(int select, Mission mission) {
        System.out.print('\u000C');
        String country = inputString("Please add the destination address");
        ArrayList<String> countries =  mission.getCountriesAllowed();
        countries.add(country);
        mission.setCountriesAllowed(countries);
        missionEditMenu(select, mission);

    }

    // 7.
    private void addDuration(int select, Mission mission) {
        System.out.print('\u000C');
        int duration = inputInt("Please insert duration in number of days");
        mission.setDuration(duration);
        missionEditMenu(select, mission);
    }

    // 8.
//    private void addMissionType(int select, Mission mission) {
//        System.out.print('\u000C');
//        int duration = inputInt("Please insert duration in months");
//        mission.setDuration(duration);
//        missionEditMenu(select, mission);
//    }

    // 9.
    private void addJob(int select, Mission mission) {

    }

    //  10.
    private void addCargoRequirement(int select, Mission mission){

    }
    // 11.
    private void addStatus(int select, Mission mission) {

    }

    // 12.
    private void showOverallInformation(Mission mission) {
        StringBuilder sb = new StringBuilder();
        sb.append(mission.displayMission());
        int editSelect;
        do {
            System.out.println(sb.toString());
            editSelect = inputInt("Please choose 0 to go back", sb.toString());
        } while (editSelect != 0);

        missionCreateMenu(mission);







//        int missionSelect = inputInt("Select mission number to edit", sb.toString());
//        while (missionSelect < 1 || missionSelect > numberOfMission) {
//            System.out.println(" ");
//            System.out.println(sb.toString());
//            missionSelect = inputInt("Please choose the right option", sb.toString());
//
//        }


    }


    private void deleteEntries(int select, Mission mission) {
        switch (select) {
            case 1:
                deleteMissionName(select, mission);
                break;
            case 2:
                deleteMissionDescription(select, mission);
                break;
            case 3:
                deleteMissionOrigin(select, mission);
                break;
            case 4:
                deleteCountriesAllowed(select, mission);
                break;
            case 5:
                deleteLaunchData(select, mission);
                break;
            case 6:
                deleteDestinationAddress(select, mission);
                break;
            case 7:
                deleteDuration(select, mission);
                break;
            //                case 8: deleteMissionType(select, mission); break;
            case 9:
                deleteJob(select, mission);
                break;
            case 10:
                deleteCargoRequirement(select, mission);
                break;
            case 11:
                deleteStatus(select, mission);
                break;
        }

    }





    public void deleteMissionName(int select, Mission mission){
        mission.setMissionName(null);
        missionEditMenu(select, mission);
    }
    public void deleteMissionDescription(int select, Mission mission){
        mission.setMissionDescription(null);
        missionEditMenu(select, mission);
    }
    public void deleteMissionOrigin(int select, Mission mission){
        mission.setMissionOrigin(null);
        missionEditMenu(select, mission);
    }
    public void deleteCountriesAllowed(int select, Mission mission){
        mission.setCountriesAllowed(null); // or
//        deleteCountriesAllowedOneByOne();

        missionEditMenu(select, mission);
    }

    // delete countries allowed one by one.
//    public void deleteCountriesAllowedOneByOne() {
//
//    }


    public void deleteLaunchData(int select, Mission mission){
        mission.setLaunchDate(null);
        missionEditMenu(select, mission);
    }
    public void deleteDestinationAddress(int select, Mission mission){
        mission.setDestinationAddress(null);
        missionEditMenu(select, mission);
    }
    public void deleteDuration(int select, Mission mission){
        mission.setDuration(0);
        missionEditMenu(select, mission);
    }
//    public void d/                case 8: deleteMissionType(select, mission){
//    missionEditMenu(select, mission);}

    // need change?
    public void deleteJob(int select, Mission mission){
        mission.getJob().clear();
        missionEditMenu(select, mission);
    }

    // need change?
    public void deleteCargoRequirement(int select, Mission mission){
        mission.setCargoRequirement(null);
        missionEditMenu(select, mission);
    }

    // need change
    public void deleteStatus(int select, Mission mission){
        missionEditMenu(select, mission);
    }

//    private void addQualification(int select, SelectionCriteria s) {
//        System.out.print('\u000C');
//        String qua = inputString("Please add the qualification (only one at a time)");
//        ArrayList<String> newQua = s.getQualification();
//        newQua.add(qua);
//        s.setQualification(newQua);
//        missionEditMenu(select, s);
//    }



//    private void idToEditView() {
//        System.out.println("Need Edit: you are in id to edit view");
//        System.out.println("Mission 1, Mission 2, mission  3");
//        for (int i = 0; i < listOfMission.size(); i++){
//            System.out.print((i + 1) + listOfMission.get(i).getMissionName());
//        }
//        int select = valueSelect(0, 8);
//
//        if (select == 0) {
//            idToEditView();
//        } else if (0 < select & select < listOfMission.size()) {
//            missionCreateMenu(select, s);
//        } else if (select == 9) {
//            viewAllCre(s);
//        }
//
//    }




//    private void viewMissionInformation(Mission mission) {
//        System.out.println("Countries: " +);
//        System.out.println();
//        System.out.println("years of work experience: " + createWorExp(s));
//        System.out.println("occupations: " + createOcc(s));
//        System.out.println("health records: " + s.getHealthRecord());
//        System.out.println("criminal records: " + s.getCriminalRecord());
//        System.out.println("computer skill: " + s.getComputerSkill());
//        System.out.println("language spoken: " + createLan(s));
//        int back = 1;
//        while (back != 0) {
//            back = inputInt("Press 0 to go back");
//        }
//        if (back == 0) {
////            criteriaMenu(s);
//        }
//
//    }
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

    private int inputInt(String displayMessage, String finallyString) {
        boolean notAnInt = true;
        int integer = 0;
        while (notAnInt) {
            Scanner sc = new Scanner(System.in);
            System.out.println(displayMessage);
            //judge whether the input is an int number
            try {
                integer = sc.nextInt();
                System.out.println(" ");
                notAnInt = false;
            }
            //not an int number
            catch (Exception e) {
                System.out.println("ERROR: Please enter proper respective number");
                System.out.println(" ");
                System.out.println(finallyString);
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

    public Date insertDate(String displayMessage) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(displayMessage);

        String date = scanner.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date2return =null;
        try {
            //Parsing the String
            date2return = dateFormat.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Launch date is invalid");
        }
        return date2return;
    }

    /**
     * draws a line to separate a particular section from another.
     */
    private void drawOneLine()
    {
        int lineWaveNumber = (20 *4);
        int countWave;

        System.out.println();
        System.out.println();
        for ( countWave = 1; countWave < lineWaveNumber; countWave++)
        {
            System.out.print("~");
        }
        System.out.println();
        System.out.println();
    }



}
