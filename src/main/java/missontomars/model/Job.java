package main.java.missontomars.model;

import main.java.missontomars.control.MissionToMars;

import java.util.ArrayList;
import java.util.Scanner;

public class Job {
    String jobName;
    String jobDescription;
    ArrayList<EmploymentRequirement> employmentRequirements;

    public Job() {
        this.jobName = "";
        this.jobDescription = "";
        employmentRequirements = new ArrayList<>();
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public ArrayList<EmploymentRequirement> getEmploymentRequirements() {
        return employmentRequirements;
    }

    public void setEmploymentRequirements(ArrayList<EmploymentRequirement> employmentRequirements) {
        this.employmentRequirements = employmentRequirements;
    }

    public void setEmploymentRequirements(int index, EmploymentRequirement employmentRequirement) {
        this.employmentRequirements.add(index, employmentRequirement);
    }

    public void setEmploymentRequirements(EmploymentRequirement employmentRequirement) {
        this.employmentRequirements.add(employmentRequirement);
    }

    public String displayJob() {
        StringBuilder sb = new StringBuilder();
        sb.append("Job information: \n \t");

        // display job name
        sb.append("\t \tjob name: " + jobName + "\n \t");

        // display job description
        sb.append("\t \tjob description: " + jobDescription + "\n \t");

        // display employment requirement
        for (int i = 0; i < employmentRequirements.size(); i++) {
            sb.append( "\n \t \t \t" + (i + 1) + ": " + employmentRequirements.get(i).displayJobTitles());
        }
        sb.append("\n");


        return sb.toString();
    }

    /*public void addJobTitle(int select, Mission mission){
        System.out.println("Job:" + getJobName());
        displayTitle();
        int option = inputInt("Press 1 to add a new title"
                + "\nPress 2 to delete title" + "\nPress 0 to go back");
        option = valueSelect(0,2,option);
        if (option == 1){
            addTitle(select,mission);
        }
        else if (option == 0){
            MissionToMars missionToMars = new MissionToMars();
            missionToMars.missionEditMenu(select, mission);
        }
        else if (option == 2){
            deleteTitle(select, mission);
        }
    }*/

    public void deleteTitle(){
        displayTitle();
        int deleteNum = inputInt("Enter the number you want to delete");
        deleteNum = valueSelect(1,employmentRequirements.size(), deleteNum);
        employmentRequirements.remove((deleteNum - 1));

    }

    public void addTitle(){
        String titleName = inputString("Enter title name");
        int requireNum = inputInt("Enter requirement numbers of employee");
        EmploymentRequirement employmentRequirement = new EmploymentRequirement();
        employmentRequirement.setJobTitle(titleName);
        employmentRequirement.setNumberEmployeeRequired(requireNum);
        employmentRequirements.add(employmentRequirement);
    }

    public String inputString(String displayMessage) {
        System.out.println(displayMessage);
        Scanner scan = new Scanner(System.in);
        String temp = scan.nextLine();
        return temp;
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

    private int valueSelect(int min, int max, int select) {
        while (!(min <= select & select <= max)) {
            select = inputInt("Please select the right option");
        }
        return select;
    }

    public void displayTitle(){
        System.out.println("Title:");
        for (int i =0; i < getEmploymentRequirements().size(); i++){
            System.out.println("Title" + (i + 1) + ":"
                    + getEmploymentRequirements().get(i).getJobTitle()
                    + ", Required Number of Employee: "
                    + getEmploymentRequirements().get(i).getNumberEmployeeRequired());
        }
    }
}
