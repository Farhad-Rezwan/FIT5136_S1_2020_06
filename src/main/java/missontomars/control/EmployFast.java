package main.java.missontomars.control;

import main.java.missontomars.model.Mission;
import main.java.missontomars.model.SelectionCriteria;
import main.java.missontomars.model.Shuttle;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployFast {
    private SelectionCriteria s;

    public EmployFast() {

    }

    /**
     * Method which show the view to set criteria
     * @param mission The selected mission in feature 1
     */
    public void criteriaMenu(Mission mission) {
        int select = inputInt("\nPress 1 for range of age"
                + "\nPress 2 for qualification"
                + "\nPress 3 for years of work experience"
                + "\nPress 4 for occupations"
                + "\nPress 5 for health records"
                + "\nPress 6 for criminal records"
                + "\nPress 7 to add computer skills"
                + "\nPress 8 to add languages spoken"
                + "\nPress 9 to view criteria created"
                + "\nPress 0 to back");
        select = valueSelect(0, 9, select);
        if (select == 0) {

        } else if (0 < select & select < 9) {
            criteriaEditMenu(select, mission);
        } else if (select == 9) {
            viewAllCre(mission);
        }
    }

    /**
     * Method show all the criteria information
     * @param mission The selected mission in feature 1
     */
    private void viewAllCre(Mission mission) {
        System.out.println("range of age: " + mission.getSelectionCriteria().getMinimumAge() + "-" + mission.getSelectionCriteria().getMaximumAge());
        System.out.println("qualification: " + createQuaStr(mission.getSelectionCriteria()));
        System.out.println("years of work experience: " + createWorExp(mission.getSelectionCriteria()));
        System.out.println("occupations: " + createOcc(mission.getSelectionCriteria()));
        System.out.println("health records: " + mission.getSelectionCriteria().getHealthRecord());
        System.out.println("criminal records: " + mission.getSelectionCriteria().getCriminalRecord());
        System.out.println("computer skill: " + mission.getSelectionCriteria().getComputerSkill());
        System.out.println("language spoken: " + createLan(mission.getSelectionCriteria()));
        int back = 1;
        while (back != 0) {
            back = inputInt("Press 0 to go back");
        }
        if (back == 0) {
            criteriaMenu(mission);
        }

    }

    /**
     * Method which view for add or delete selected criteria
     * @param select The number of selected criteria
     * @param mission The selected mission in feature1
     */
    private void criteriaEditMenu(int select, Mission mission) {
        SelectionCriteria s = mission.getSelectionCriteria();
        boolean check = true;
        while (check) {
            if (select == 1) {
                System.out.println(s.getMinimumAge() + "-" + s.getMaximumAge());
            } else if (select == 2) {
                for (int i = 0; i < s.getQualification().size(); i++) {
                    System.out.println((i + 1) + "： " + s.getQualification().get(i));
                }
            } else if (select == 3) {
                for (int i = 0; i < s.getExperience().size(); i++) {
                    System.out.println((i + 1) + ": " + s.getExperience().get(i) + " years");
                }
            } else if (select == 4) {
                for (int i = 0; i < s.getOccupation().size(); i++) {
                    System.out.println((i + 1) + ": " + s.getOccupation().get(i));
                }
            } else if (select == 5) {
                System.out.println(s.getHealthRecord());
            } else if (select == 6) {
                System.out.println(s.getCriminalRecord());
            } else if (select == 7) {
                System.out.println(s.getComputerSkill());
            } else if (select == 8) {
                for (int i = 0; i < s.getLanguageSpoken().size(); i++) {
                    System.out.println((i + 1) + ": " + s.getLanguageSpoken().get(i));
                }
            }
            int editSelect = inputInt("Press 1 to add" + "\nPress 2 to delete" + "\nPress 0 to go back");
            editSelect = valueSelect(0, 2, editSelect);
            boolean isEmpty = checkEmpty(select, s);
            while (isEmpty & editSelect == 2) {
                editSelect = inputInt("This criteria is empty. You can not delete it. Please select again");
            }
            if (editSelect == 1) {
                if (select == 1) {
                    addAgeRange(s);
                }
                if (select == 2) {
                    addQualification(s);
                }
                if (select == 3) {
                    addWorkExp(s);
                }
                if (select == 4) {
                    addOcc(s);
                }
                if (select == 5) {
                    addHealth(s);
                }
                if (select == 6) {
                    addCri(s);
                }
                if (select == 7) {
                    addComSkill(s);
                }
                if (select == 8) {
                    addLanguage(s);
                }
            } else if (editSelect == 2) {
                delete(select, s);
            } else if (editSelect == 0) {
                check = false;
            }
        }
        mission.setSelectionCriteria(s);
        criteriaMenu(mission);
    }

    /**
     * Method which set age range
     * @param s The selection criteria of the mission
     */
    private void addAgeRange(SelectionCriteria s) {
        int minAge = inputInt("Please enter the minimum age");
        int maxAge = inputInt("please enter the maximum age");
        while (minAge >= maxAge) {
            System.out.println("minimum age must smaller than maximum age");
            minAge = inputInt("Please enter the minimum age");
            maxAge = inputInt("please enter the maximum age");
        }
        s.setMinimumAge(minAge);
        s.setMaximumAge(maxAge);
    }

    /**
     * Method which set qualification
     * @param s The selection criteria of the mission
     */
    private void addQualification(SelectionCriteria s) {

        String qua = inputString("Please add the qualification (only one at a time)");
        ArrayList<String> newQua = s.getQualification();
        newQua.add(qua);
        s.setQualification(newQua);
    }

    /**
     * Method which set work experience
     * @param s The selection criteria of the mission
     */
    private void addWorkExp(SelectionCriteria s) {
        int workExp = inputInt("Please input the work experience (only one at a time)");
        ArrayList<Integer> newWorkExp = s.getExperience();
        newWorkExp.add(workExp);
        s.setExperience(newWorkExp);
    }

    /**
     * Method which set occupation
     * @param s The selection criteria of the mission
     */
    private void addOcc(SelectionCriteria s) {

        String occ = inputString("Please add the occupation (only one at a time)");
        ArrayList<String> newOcc = s.getOccupation();
        newOcc.add(occ);
        s.setOccupation(newOcc);
    }

    /**
     * Method which set health record
     * @param s The selection criteria of the mission
     */
    private void addHealth(SelectionCriteria s) {

        String health = inputString("Please add the health record");
        s.setHealthRecord(health);

    }

    /**
     * Method which set criminal record
     * @param s The selection criteria of the mission
     */
    private void addCri(SelectionCriteria s) {

        String cri = inputString("Please add the criminal record");
        s.setCriminalRecord(cri);
    }

    /**
     * Method which set computer skill
     * @param s The selection criteria of the mission
     */
    private void addComSkill(SelectionCriteria s) {

        String com = inputString("Please add the computer skill");
        s.setHealthRecord(com);
    }

    /**
     * Method which set language
     * @param s The selection criteria of the mission
     */
    private void addLanguage(SelectionCriteria s) {

        String lan = inputString("Please add the language (only one at a time)");
        ArrayList<String> newLan = s.getLanguageSpoken();
        newLan.add(lan);
        s.setLanguageSpoken(newLan);
    }

    /**
     * Method which delete criteria
     * @param select The selection criteria of the mission
     * @param s The selection criteria of the mission
     */
    private void delete(int select, SelectionCriteria s){
        if (select == 1){
            int i = inputInt(s.getMinimumAge() + "-" + s.getMaximumAge()
                    + "\nPress 1 to delete"
                    + "\nPress 0 to go back");
            i = valueSelect(0,1,i);
            if (i == 1){
                s.setMinimumAge(0);
                s.setMaximumAge(0);
            }
            else if(i == 0){
            }
        }
        if (select == 2){
            for (int i = 0; i < s.getQualification().size(); i++) {
                System.out.println((i + 1) + "： " + s.getQualification().get(i));
            }
            int i = inputInt("\nPress 1 to delete"
                    + "\nPress 0 to go back");
            i = valueSelect(0,1,i) ;
            if (i == 1){
                int selection = inputInt("Please select the number");
                selection = valueSelect(1,s.getQualification().size(),selection);
                s.getQualification().remove((selection - 1));
            }
            else if(i == 0){
            }
        }
        if (select == 3){
            for (int i = 0; i < s.getExperience().size(); i++) {
                System.out.println((i + 1) + ": " + s.getExperience().get(i) + " years");
            }
            int i = inputInt("\nPress 1 to delete" + "\nPress 0 to go back");
            i = valueSelect(0,1,i) ;
            if (i == 1){
                int selection = inputInt("Please select the number");
                selection = valueSelect(1,s.getExperience().size(),selection);
                s.getExperience().remove((selection - 1));
            }
            else if(i == 0){
            }
        }
        if (select == 4){
            for (int i = 0; i < s.getOccupation().size(); i++) {
                System.out.println((i + 1) + ": " + s.getOccupation().get(i));
            }
            int i = inputInt("\nPress 1 to delete" + "\nPress 0 to go back");
            i = valueSelect(0,1,i) ;
            if (i == 1){
                int selection = inputInt("Please select the number");
                selection = valueSelect(1,s.getOccupation().size(),selection);
                s.getOccupation().remove((selection - 1));
                //criteriaEditMenu(select, s);
            }
            else if(i == 0){
            }
        }
        if (select == 5){
            System.out.println(s.getHealthRecord());
            int i = inputInt("\nPress 1 to delete" + "\nPress 0 to go back");
            i = valueSelect(0,1,i) ;
            if (i == 1){
                s.setHealthRecord("");
            }
            else if(i == 0){
            }
        }
        if (select == 6){
            System.out.println(s.getCriminalRecord());
            int i = inputInt("\nPress 1 to delete" + "\nPress 0 to go back");
            i = valueSelect(0,1,i) ;
            if (i == 1){
                s.setCriminalRecord("");
            }
            else if(i == 0){

            }
        }
        if (select == 6){
            System.out.println(s.getComputerSkill());
            int i = inputInt("\nPress 1 to delete" + "\nPress 0 to go back");
            i = valueSelect(0,1,i) ;
            if (i == 1){
                s.setComputerSkill("");
            }
            else if(i == 0){
            }
        }
        if (select == 7){
            for (int i = 0; i < s.getLanguageSpoken().size(); i++) {
                System.out.println((i + 1) + ": " + s.getLanguageSpoken().get(i));
            }
            int i = inputInt("\nPress 1 to delete" + "\nPress 0 to go back");
            i = valueSelect(0,1,i) ;
            if (i == 1){
                int selection = inputInt("Please select the number");
                selection = valueSelect(1,s.getLanguageSpoken().size(),selection);
                s.getExperience().remove((selection - 1));
            }
            else if(i == 0){
            }
        }
    }

    /**
     * Method which input String
     * @param displayMessage Message to display
     * @return A string of the user input
     */
    public String inputString(String displayMessage) {
        System.out.println(displayMessage);
        Scanner scan = new Scanner(System.in);
        String temp = scan.nextLine();
        return temp;
    }

    /**
     * Method which input int
     * @param displayMessage Message to display
     * @return An int of the user input
     */
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


    /**
     * Method which value the input
     * @param min The smallest int
     * @param max The biggest int
     * @param select User selection
     * @return Valued int
     */
    private int valueSelect(int min, int max, int select) {
        while (!(min <= select & select <= max)) {
            select = inputInt("Please select the right option");
        }
        return select;
    }


    /**
     * Method which show qualification
     * @param s The selection criteria of the mission
     * @return A display string
     */
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

     /** Method which check criteria can be deleted or not
     * @param select The selection number of user
     * @param s The selection criteria of the mission
     * @return A boolean show whether the criteria is empty or not
     */
    private boolean checkEmpty(int select, SelectionCriteria s){
        boolean isEmpty = true;
        if (select == 1){
            if (s.getMinimumAge() != 0 & s.getMaximumAge() != 0){
                isEmpty = false;
            }
        }
        if (select == 2){
            if (s.getQualification().size() > 0){
                isEmpty = false;
            }
        }
        if (select == 3){
            if (s.getExperience().size() > 0){
                isEmpty = false;
            }
        }
        if (select == 4){
            if (s.getOccupation().size() > 0){
                isEmpty =false;
            }
        }
        if (select == 5){
            if (!s.getHealthRecord().equals("")){
                isEmpty = false;
            }
        }
        if (select == 6){
            if (!s.getCriminalRecord().equals("")){
                isEmpty = false;
            }
        }
        if (select == 7){
            if (!s.getComputerSkill().equals("")){
                isEmpty = false;
            }
        }
        if (s.getLanguageSpoken().size() > 0){
            isEmpty = false;
        }
        return isEmpty;
    }

    /**
     * Method which show work experience
     * @param s Selection criteria
     * @return A display string
     */
    private String createWorExp(SelectionCriteria s) {
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

    /**
     * Method which show occupation
     * @param s Selection criteria
     * @return A display string
     */
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

    /**
     * Method which show language
     * @param s Selection criteri
     * @return A display string
     */
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
}
