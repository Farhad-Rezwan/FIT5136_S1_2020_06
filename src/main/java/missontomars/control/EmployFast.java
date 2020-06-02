package main.java.missontomars.control;

import main.java.missontomars.model.Mission;
import main.java.missontomars.model.SelectionCriteria;

import java.util.Scanner;

public class EmployFast {
    public EmployFast() {
    }

    public void createSelectionCriteriaView(){
        System.out.print("Shuttle selected"
        + "\nPress 1 to acquire the employment requirements"
        + "\nPress 2 to create selection criteria"
        + "\nPress 0 to back to change a shuttle");
        int select = valueSelect(0,2);
        if(select == 2){
            SelectionCriteria selectionCriteria = new SelectionCriteria();
            criteriaMenu(selectionCriteria);
        }
    }

    private void criteriaMenu(SelectionCriteria s){
        System.out.print("Shuttle selected"
                + "\nPress 1 for range of age"
                + "\nPress 2 for qualification"
                + "\nPress 3 for years of work experience"
                + "\nPress 4 for occupations"
                + "\nPress 5 for health records"
                + "\nPress 6 for criminal records"
                + "\nPress 7 to add computer skills"
                + "\nPress 8 to add languages spoken"
                + "\nPress 9 to view criteria created"
                + "\nPress 0 to back");
        int select = valueSelect(0,9);
        if (select == 0){
            createSelectionCriteriaView();
        }
        else if (0 < select & select < 9){
            criteriaEditMenu(select,s);
        }
        else if (select == 9){
            viewAllCre(s);
        }
    }

    private void viewAllCre(SelectionCriteria s){
        System.out.println("range of age: " + s.getMinimumAge() + "-" + s.getMaximumAge());
        System.out.println("qualification: " + createQuaStr(s));
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
        if (back == 0){
            criteriaMenu(s);
        }

    }

    private void criteriaEditMenu(int select, SelectionCriteria s){
        if (select == 1){
            System.out.println(s.getMinimumAge() + "-" + s.getMaximumAge());
        }
        else if (select == 2){
            for (int i = 0; i < s.getQualification().size(); i++){
                System.out.println( (i + 1) + "： " + s.getQualification().get(i));
            }
        }
        else if(select == 3){
            for (int i = 0; i < s.getExperience().size(); i++){
                System.out.println( (i + 1) + ": " + s.getExperience().get(i) + " years");
            }
        }
        else if(select == 4){
            for (int i = 0; i < s.getOccupation().size(); i++){
                System.out.println( (i + 1) + ": " + s.getOccupation().get(i));
            }
        }else if(select == 5){
            System.out.println(s.getHealthRecord());
        }
        else if(select == 6){
            System.out.println(s.getCriminalRecord());
        }
        else if(select == 7){
            System.out.println(s.getComputerSkill());
        }
        else if(select == 8){
            for (int i = 0; i < s.getLanguageSpoken().size(); i++){
                System.out.println( (i + 1) + ": " + s.getLanguageSpoken().get(i));
            }
        }
        int editSelect = inputInt("Press 1 to add" + "\nPress 2 to delete" + "\nPress 0 to go back");
        while (editSelect < 0 || editSelect > 2){
            editSelect = inputInt("Please select an right option");
        }
        if (editSelect == 1){
            if (select == 1){
                addAgeRange(s,select);
            }
            if (select == 2){
                addQualification(select,s);
            }
            if (select == 3){
                addWorkExp(select, s);
            }
            if (select == 4){
                addOcc(select, s);
            }
            if (select == 5){
                addHealth(select, s);
            }
            if (select == 6){
                addCri(select, s);
            }
            if (select == 7){
                addComSkill(select, s);
            }
            if (select == 8){
                addLanguage(select, s);
            }
        }
        else if(editSelect == 2){

        }
        else if(editSelect == 0){
            criteriaMenu(s);
        }
    }

    private void addAgeRange(SelectionCriteria s, int select){
        int minAge = inputInt("Please enter the minimum age");
        int maxAge = inputInt("please enter the maximum age");
        while(minAge >= maxAge){
            System.out.println("minimum age must smaller than maximum age");
            minAge = inputInt("Please enter the minimum age");
            maxAge = inputInt("please enter the maximum age");
        }
        s.setMinimumAge(minAge);
        s.setMaximumAge(maxAge);
        criteriaEditMenu(select, s);
    }

    private void addQualification(int select, SelectionCriteria s){
        System.out.print('\u000C');
        String qua = inputString("Please add the qualification (only one at a time)");
        ArrayList<String> newQua = s.getQualification();
        newQua.add(qua);
        s.setQualification(newQua);
        criteriaEditMenu(select, s);
    }

    private void addWorkExp(int select, SelectionCriteria s){
        System.out.print('\u000C');
        int workExp = inputInt("Please input the work experience (only one at a time)");
        ArrayList<Integer> newWorkExp = s.getExperience();
        newWorkExp.add(workExp);
        s.setExperience(newWorkExp);
        criteriaEditMenu(select, s);
    }

    private void addOcc(int select, SelectionCriteria s){
        System.out.print('\u000C');
        String occ = inputString("Please add the occupation (only one at a time)");
        ArrayList<String> newOcc = s.getOccupation();
        newOcc.add(occ);
        s.setOccupation(newOcc);
        criteriaEditMenu(select, s);
    }

    private void addHealth(int select, SelectionCriteria s){
        System.out.print('\u000C');
        String health = inputString("Please add the health record");
        s.setHealthRecord(health);
        criteriaEditMenu(select, s);
    }

    private void addCri(int select, SelectionCriteria s){
        System.out.print('\u000C');
        String cri = inputString("Please add the criminal record");
        s.setHealthRecord(cri);
        criteriaEditMenu(select, s);
    }

    private void addComSkill(int select, SelectionCriteria s){
        System.out.print('\u000C');
        String com = inputString("Please add the computer skill");
        s.setHealthRecord(com);
        criteriaEditMenu(select, s);
    }

    private void addLanguage(int select, SelectionCriteria s){
        System.out.print('\u000C');
        String lan = inputString("Please add the language (only one at a time)");
        ArrayList<String> newLan = s.getLanguageSpoken();
        newLan.add(lan);
        s.setLanguageSpoken(newLan);
        criteriaEditMenu(select, s);
    }





    public String inputString(String displayMessage)
    {
        System.out.println(displayMessage);
        Scanner scan = new Scanner(System.in);
        String temp = scan.nextLine();
        return temp;
    }


    private int inputInt(String displayMessage)
    {
        boolean notAnInt = true;
        int integer = 0;
        while(notAnInt)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println(displayMessage);
            //judge whether the input is an int number
            try
            {
                integer = sc.nextInt();
                notAnInt = false;
            }
            //not an int number
            catch(Exception e)
            {
                System.out.println("Please enter right options");
            }
        }
        return integer;
    }

    private int valueSelect(int min, int max){
        int select = -1;
        while (!(min <= select &  select <= max )) {
            select = inputInt("Please select an option");
        }
        return select;
    }

    private String createQuaStr(SelectionCriteria s){
        String str = "";
        for(int i =0; i < s.getQualification().size(); i++){
            if (i == 0){
                str = s.getQualification().get(i);
            }
            else if (i > 0){
                str = str + "," + s.getQualification().get(i);
            }
        }
        return str;
    }

    private String createWorExp(SelectionCriteria s){
        String exp = "";
        for(int i =0; i < s.getExperience().size(); i++){
            if (i == 0){
               exp = String.valueOf(s.getExperience().get(i));
            }
            else if (i > 0){
                exp = exp + "," + s.getExperience().get(i);
            }
        }
        return exp;
    }

    private String createOcc(SelectionCriteria s){
        String occ = "";
        for(int i =0; i < s.getOccupation().size(); i++){
            if (i == 0){
                occ = String.valueOf(s.getOccupation().get(i));
            }
            else if (i > 0){
                occ = occ + "," + s.getOccupation().get(i);
            }
        }
        return occ;
    }

    private String createLan(SelectionCriteria s){
        String lan = "";
        for(int i =0; i < s.getLanguageSpoken().size(); i++){
            if (i == 0){
                lan = String.valueOf(s.getLanguageSpoken().get(i));
            }
            else if (i > 0){
                lan = lan + "," + s.getLanguageSpoken().get(i);
            }
        }
        return lan;
    }
}
