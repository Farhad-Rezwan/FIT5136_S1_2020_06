package main.java.missontomars.control;

import main.java.missontomars.model.*;

import java.util.ArrayList;
import java.util.List;
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

//    public void loginScreen() {
//        System.out.println("Wellcome to mission to mars");
//        System.out.println("Enter your username");
//
//    }


    private void missionCreateMenu(Mission mission) {
        System.out.print("Selected Mission"
                + "\nPress 1 for country information"
                + "\nPress 2 for co-ordinator information"
                + "\nPress 3 for job information"
                + "\nPress 4 for cargo requirement"
                + "\nPress 5 for launch date"
                + "\nPress 6 for duration"
                + "\nPress 7 for status of mission"
                + "\nPress 8 to view mission created"
                + "\nPress 0 to back");
        int select = valueSelect(0, 8);
        if (select == 0) {
            idToEditView();
        } else if (0 < select & select < 9) {
            missionEditMenu(select, mission);
        } else if (select == 9) {
//            viewAllCre(s);
        }
    }


//    int id;
//    String missionName;
//    String missionDescription;
//    String missionOrigin;
//    List<String> countriesAllowed;
//    String  launchDate;
//    List<String> destinationAddress;
//    int duration;
//    String status;
//    List<String> missionType;
//    ArrayList<Job> job;
//    CargoRequirement cargoRequirement;
//    private SelectionCriteria selectionCriteria;

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

        int editSelect = inputInt("Press 1 to add" + "\nPress 2 to delete" + "\nPress 0 to go back");
        while (editSelect < 0 || editSelect > 2) {
            editSelect = inputInt("Please select an right option");
        }
        if (editSelect == 1) {

            switch (select) {
                case 1: addMissionName(); break;
                case 2: addMissionDesceription(); break;
                case 3: addMissionOrigin(); break;
                case 4: addLaunchData(); break;
                case 6: addDestinationAddress(); break;
                case 7: addDuration(); break;
                case 8: addMissionType(); break;
                case 9: addJob(); break;
                case 10: addCargoRequirement(); break;
            }
        }
    }

    private void addQualification(int select, SelectionCriteria s) {
        System.out.print('\u000C');
        String qua = inputString("Please add the qualification (only one at a time)");
        ArrayList<String> newQua = s.getQualification();
        newQua.add(qua);
        s.setQualification(newQua);
        criteriaEditMenu(select, s);
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
            criteriaMenu(s);
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
