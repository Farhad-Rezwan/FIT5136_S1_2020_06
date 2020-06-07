package main.java.missontomars.control;

import main.java.missontomars.model.*;
import main.java.missontomars.model.Feature2.GetShuttle;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MissionToMars {
    private static String userType;
    private static ArrayList<Mission> listOfMission;
    private static ArrayList<Shuttle> listOfShuttle;



    public MissionToMars(ArrayList<Mission> listOfMission, ArrayList<Shuttle> listOfShuttle) {
        this.listOfMission = listOfMission;
        this.listOfShuttle = listOfShuttle;
    }

    public MissionToMars () {

    }


    // login display

    public static void login() {
        //Login starts here
        Login login = new Login();
        ArrayList<String[]> allUser = login.readUser();
        User user = login.login(allUser);
        userType = user.getAccountType();

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
                + "\nPress 8 for job information"
                + "\nPress 9 for cargo requirement"
                + "\nPress 10 for status of mission"
                + "\nPress 11 for mission overall information"
                + "\nPress 12 for setting the shuttle for the mission"
                + "\nPress 0 to back"
                + "\n");
        int select = valueSelect(0, 12);
        if (select == 0) {
            idToEditView();
        } else if (0 < select & select < 11) {
            missionEditMenu(select, mission);
        } else if (select == 11) {
            showOverallInformation(mission);
        } else if (select == 12) {
            int index = listOfMission.indexOf(mission);
            feature2(index);
        }
    }


    private void missionEditMenu(int select, Mission mission) {

        System.out.println(displayHeader(select, mission));

        int editSelect = inputInt("Press 1 to add/edit" + "\nPress 2 to delete" + "\nPress 0 to go back");
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

    // displays information when you choose to edit that option
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
                    str.append("There is no mission description set");
                break;
            case 3:
                if (null != mission.getMissionOrigin())
                    str.append("Mission origin: " + mission.getMissionOrigin());
                else
                    str.append("There is no mission origin set");
                break;
            case 4:
                if (mission.getCountriesAllowed().size() > 0){
                    str.append("Countries allowed");
                    for (int i = 0; i < mission.getCountriesAllowed().size(); i++)
                        str.append("  " + (i + 1) + ": " + mission.getCountriesAllowed().get(i));
                } else {
                    str.append("There is no countries allowed yet");
                }
                break;
            case 5:
                if (null != mission.getLaunchDate())
                    str.append("Mission launch date: " + mission.getLaunchDate());
                else {
                    str.append("There is no launch date is not set");
                }
                break;
            case 6:
                if (null != mission.getDestinationAddress())
                    str.append("Mission destination address: " + mission.getDestinationAddress());
                else
                    str.append("There is no destination address set");
                break;
            case 7:
                if (mission.getDuration() > 0){
                    str.append("Duration is set to: ");
                    if (mission.getDuration() > 1)
                        str.append(mission.getDuration() + " days");
                    else
                        str.append(mission.getDuration() + " day");
                } else
                    str.append("There is no duration set for the mission");
                break;
            case 8:
                if (null != mission.getJob()) {
                    for (int i = 0; i < mission.getJob().size(); i++)
                        str.append( (i + 1) + ": " + mission.getJob().get(i).displayJob());
                } else
                    str.append("There is no job set");
                break;
            case 9:
                if (null != mission.getCargoRequirement()) {
                    str.append(mission.getCargoRequirement().displayCargoRequirement());
                }
                else str.append("There is no cargo requirement set");
                break;
            case 10:
                if (null != mission.getStatus())
                    str.append("The mission status is :" + mission.getStatus());
                else {
                    str.append("Mission status is not set");
                }
                break;

        }
        return str.toString();
    }

    // add the entries, nevigates through edit options
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
            case 8:
                editJobsMenu(mission);
                break;
            case 9:
                addCargoRequirement(select, mission);
                break;
            case 10:
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

    private void getAllMission(){

    }

    public void idToEditView() {
        int maxOption;
        int numberOfMission = listOfMission.size();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numberOfMission; i++) {
            sb.append((i + 1) + "： " + listOfMission.get(i).getMissionName() + "\n");
        }
        if ( userType.equals("Coordinator")) {
            sb.append((numberOfMission + 1) +  "： " + "Create a new mission");

        }

        System.out.println(sb.toString());

        int missionSelect = inputInt("Select mission number to edit", sb.toString());
        while (missionSelect < 1 || missionSelect > numberOfMission + 1 ) {
            System.out.println(" ");
            System.out.println(sb.toString());
            missionSelect = inputInt("Please choose the right option", sb.toString());

        }
        if (missionSelect == numberOfMission + 1) {
            Mission mission = new Mission();
            listOfMission.add(mission);
            missionCreateMenu(listOfMission.get(missionSelect -1 ));
        } else {
            missionCreateMenu(listOfMission.get(missionSelect - 1));
        }
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
        mission.setMissionOrigin(origin);
        missionEditMenu(select, mission);
    }

    // 4.
    private void addCountriesAllowed(int select, Mission mission) {
        System.out.print('\u000C');
        String country = inputString("Please insert the name of country");
        mission.setCountriesAllowed(country);
        missionEditMenu(select, mission);
    }

    // 5.
    private void addLaunchData(int select, Mission mission){
        System.out.print('\u000C');
        mission.setLaunchDate(insertDate("Please enter proper launch date"));
        missionEditMenu(select, mission);
    }

    // 6. destination address selection menu
    private void addDestinationAddress(int select, Mission mission) {
        System.out.print("Select destination address: "
                + "\nPress 1 INSIGHT"
                + "\nPress 2 PHOENIX"
                + "\nPress 3 VIKING 1"
                + "\nPress 4 PATHFINDER"
                + "\nPress 5 OPPORTUNITY"
                + "\nPress 6 VIKING 2"
                + "\nPress 7 CURIOSITY"
                + "\nPress 8 SPIRIT"
                + "\nPress 0 to back"
                + "\n");
        int choise = valueSelect(0, 8);
        if (choise == 0) {
            missionEditMenu(select, mission);
        } else if (0 < choise & choise < 9) {
            switch (choise) {
                case 1:
                    mission.setDestinationAddress("INSIGHT");
                    break;
                case 2:
                    mission.setDestinationAddress("PHOENIX");
                    break;
                case 3:
                    mission.setDestinationAddress("VIKING 1");
                    break;
                case 4:
                    mission.setDestinationAddress("PATHFINDER");
                    break;
                case 5:
                    mission.setDestinationAddress("OPPORTUNITY");
                    break;
                case 6:
                    mission.setDestinationAddress("VIKING 2");
                    break;
                case 7:
                    mission.setDestinationAddress("CURIOSITY");
                    break;
                case 8:
                    mission.setDestinationAddress("SPIRIT");
                    break;

            }
        }
        missionEditMenu(select, mission);
    }

    // 7.
    private void addDuration(int select, Mission mission) {
        System.out.print('\u000C');
        int duration = inputInt("Please insert duration in number of days");
        mission.setDuration(duration);
        missionEditMenu(select, mission);
    }





    private void editJobsMenu(Mission mission) {
        StringBuilder str = new StringBuilder();
        if (null != mission.getJob()) {
            for (int i = 0; i < mission.getJob().size(); i++)
                str.append( "Press " + (i + 1) + " to edit: " +  mission.getJob().get(i).getJobName() + "\n");
        } else
            str.append("There is no job set");
        str.append("Press " + (mission.getJob().size() + 1) + " to add a job \n");
        str.append("Press 0 to go back");
        System.out.println(str.toString());
        int editSelect = inputInt("Select your option");
        while (editSelect < 0 || editSelect > mission.getJob().size() + 1) {
            editSelect = inputInt("Please select an right option");
        }

        if (editSelect == 0) {
            System.out.println(displayHeader(8, mission));
            missionEditMenu(editSelect, mission);
        } else if (editSelect == mission.getJob().size() + 1){
            createNewJob(mission);
            System.out.println(editSelect);
        } else {
            jobEditMenu(mission.getJob().get(editSelect - 1), mission);
        }


    }

    private void createNewJob(Mission mission) {
        Job job = new Job();
        job.setJobName(inputString("Please insert job name "));
        job.setJobDescription(inputString("Please insert job description"));

        createNewEmploymentrequirementWithMission(mission, job);
        editJobsMenu(mission);
    }

    private void createNewEmploymentrequirementWithMission(Mission mission, Job job){
        ArrayList<EmploymentRequirement> empList = new ArrayList<>();
        String jobTitle  = inputString("Please insert job title ");
        int numberEmployeeRequired = inputInt("Please enter number of employee required ");
        EmploymentRequirement emp = new EmploymentRequirement(numberEmployeeRequired, jobTitle);
        job.setEmploymentRequirements(emp);
        mission.setJob(job);
        addEmploymentRequirement(job, mission);
    }

    /**
     * job edit menu for the job name, description and employment requiremets
     */

    private void jobEditMenu(Job job, Mission mission) {

        System.out.println(job.displayJob());

        int editSelect = inputInt("Press 1 to edit job name"
                + "\nPress 2 edit job description"
                + "\nPress 3 edit job employment requirement"
                + "\nPress 0 to go back");
        while (editSelect < 0 || editSelect > 3) {
            editSelect = inputInt("Please select an right option");
        }

        if (editSelect == 0) {
            System.out.println(displayHeader(8, mission));
            editJobsMenu(mission);
        } else {
            System.out.println(displayHeaderJob(editSelect, job));
            editJobEntries(editSelect, job, mission);
        }



    }

    private String displayHeaderJob(int select, Job job) {

        StringBuilder str = new StringBuilder();
        System.out.print('\u000C');


        switch (select) {
            case 1:
                if (null != job.getJobName())
                    str.append("Job name is set to: " + job.getJobName());
                else
                    str.append("There is no job name set");
                break;
            case 2:
                if (null != job.getJobDescription())
                    str.append("Mission description: " + job.getJobDescription());
                else
                    str.append("There is no job description set");
                break;
            case 3:
                if (job.getEmploymentRequirements().size() > 0){
                    str.append("Employment Requirements");
                    for (int i = 0; i < job.getEmploymentRequirements().size(); i++)
                        str.append("\n \t " + (i + 1) + ": " + job.getEmploymentRequirements().get(i).displayJobTitles());
                } else {
                    str.append("There is no employment requirement set yet");
                }
                break;

        }
        return str.toString();
    }

    private void editJobEntries(int select, Job job, Mission mission) {

        switch (select) {
            case 1:
                addJobName(job, mission);
                break;
            case 2:
                addJobDescription(job, mission);
                break;
            case 3:
                addEmploymentRequirement(job, mission);
                break;
        }
    }

    private void addJobName(Job job, Mission mission ) {
        System.out.print('\u000C');
        String missionName  = inputString("Please insert job name: ");
        job.setJobName(missionName);
        jobEditMenu(job, mission);

    }
    private void addJobDescription(Job job, Mission mission) {
        System.out.print('\u000C');
        String missionDescription = inputString("Please insert job description: ");
        job.setJobDescription(missionDescription);
        jobEditMenu(job, mission);
    }

    private void addEmploymentRequirement (Job job, Mission mission) {
        StringBuilder str = new StringBuilder();
        if (null != job.getEmploymentRequirements()) {
            for (int i = 0; i < job.getEmploymentRequirements().size(); i++)
                str.append( "Press " + (i + 1) + " to edit: " +  job.getEmploymentRequirements().get(i).getJobTitle() + "\n");
        } else
            str.append("There is no employment requirement set");
        str.append("Press " + (job.getEmploymentRequirements().size() + 1) + " new employment requirement \n");
        str.append("Press 0 to go back");
        System.out.println(str.toString());
        int editSelect = inputInt("Select your option");
        while (editSelect < 0 || editSelect > job.getEmploymentRequirements().size() + 1) {
            editSelect = inputInt("Please select a right option");
        }

        if (editSelect == 0) {
            jobEditMenu(job, mission);
        } else if (editSelect == job.getEmploymentRequirements().size() + 1){
            createNewEmploymentrequirement(mission, job);
            System.out.println(editSelect);
        } else {
//            jobEditMenu(mission.getJob().get(editSelect - 1), mission);
            employmentRequirementEditMenu(job.getEmploymentRequirements().get(editSelect - 1), job, mission);
        }
    }

    /**
     * to create new employment requirements
     */

    public void createNewEmploymentrequirement(Mission mission, Job job) {
        ArrayList<EmploymentRequirement> empList = new ArrayList<>();
        String jobTitle  = inputString("Please insert job title ");
        int numberEmployeeRequired = inputInt("Please enter number of employee required ");
        EmploymentRequirement emp = new EmploymentRequirement(numberEmployeeRequired, jobTitle);
        job.setEmploymentRequirements(emp);
        addEmploymentRequirement(job, mission);
    }

    /**
     * employment requirment menu selection
     */
    private void employmentRequirementEditMenu(EmploymentRequirement empReq, Job job, Mission mission) {
        System.out.println(empReq.displayJobTitles());

        int editSelect = inputInt("Press 1 to edit job title"
                + "\nPress 2 edit number of employee required"
                + "\nPress 0 to go back");
        while (editSelect < 0 || editSelect > 2) {
            editSelect = inputInt("Please select an right option");
        }

        if (editSelect == 0) {
            System.out.println(displayHeaderJob(3, job));
            addEmploymentRequirement(job, mission);
        } else {
            System.out.println(displayHeaderJobTitle(editSelect, empReq));
            editEmploymentrequirementEntries(editSelect, job, empReq, mission);
        }

    }

    // for editing the employment requirments
    private void editEmploymentrequirementEntries(int select, Job job, EmploymentRequirement empRec, Mission mission) {

        switch (select) {
            case 1:
                addTitleName(job, empRec, mission);
                break;
            case 2:
                addTitleNumberEmployeeRequired(job, empRec, mission);
                break;
        }
    }

    // for adding job title
    private void addTitleName(Job job, EmploymentRequirement employmentRequirement, Mission mission) {
        System.out.print('\u000C');
        String titleName  = inputString("Please insert job title name: ");
        employmentRequirement.setJobTitle(titleName);
        employmentRequirementEditMenu(employmentRequirement, job, mission);

    }
    private void addTitleNumberEmployeeRequired(Job job, EmploymentRequirement employmentRequirement, Mission mission) {
        System.out.print('\u000C');
        int numberEmployeeRequired = inputInt("Please insert number of employee required for this job title");
        employmentRequirement.setNumberEmployeeRequired(numberEmployeeRequired);
        employmentRequirementEditMenu(employmentRequirement, job, mission);
    }

    private String displayHeaderJobTitle(int select, EmploymentRequirement empReq) {

        StringBuilder str = new StringBuilder();
        System.out.print('\u000C');


        switch (select) {
            case 1:
                if (null != empReq.getJobTitle())
                    str.append("Job title is set to: " + empReq.getJobTitle());
                else
                    str.append("There is no job title set");
                break;
            case 2:
                if (0 != empReq.getNumberEmployeeRequired())
                    str.append("employee required is set to: " + empReq.getNumberEmployeeRequired());
                else
                    str.append("There is number of employee required for job title is set");
                break;

        }
        return str.toString();
    }





    //  9. for adding cargo requirements
    private void addCargoRequirement(int select, Mission mission){
        System.out.print('\u000C');
        if (null != mission.getCargoRequirement()) {
            mission.setCargoRequirement(null);
        }

        CargoRequirement cargoRequirement = new CargoRequirement();
        mission.setCargoRequirement(cargoRequirement);

        int newSelect = 3;
        do  {
            String cargoFor = inputString("Please add cargo required for (mission/other mission/journey)");
            mission.getCargoRequirement().setCargoFor(cargoFor);
            System.out.println("Press 1 to add more cargo for \n Press 0 for done");
            newSelect = valueSelect(0,1);
        } while(newSelect == 1);


        int cargoQuantityRequired = inputInt("Please insert cargo quantity required");
        mission.getCargoRequirement().setCargoQuantity(cargoQuantityRequired);
        String itemRequired = inputString("Please insert cargo item required separated by comma");
        String [] items = itemRequired.split(",");
        for (String item : items) {
            mission.getCargoRequirement().setCargoRequired(item);
        }



        int editSelect = 3;
        do  {
            Cargo cargo = new Cargo();
            cargo.setCargo(inputString("Please insert cargo container name"));
            cargo.setQuantityAvailable(inputInt("Please insert quantity available in the container"));
            mission.getCargoRequirement().setCargoList(cargo);
            System.out.println("Press 1 to add more containers \n Press 0 for done");
            editSelect = valueSelect(0,1);
        } while(editSelect == 1);




        missionEditMenu(select, mission);


    }
    // 10. for addiong status
    private void addStatus(int select, Mission mission) {
        System.out.print("Select status of mission: "
                + "\nPress 1 for Planning Phase"
                + "\nPress 2 Departed Earth"
                + "\nPress 3 Landed on Mars"
                + "\nPress 4 Mission in progress"
                + "\nPress 5 Returned to Earth"
                + "\nPress 6 Mission Completed"
                + "\nPress 0 to back"
                + "\n");
        int choise = valueSelect(0, 6);
        if (choise == 0) {
            mission.setStatus("Planning Phase");
            missionEditMenu(select, mission);
        } else if (0 < choise & choise < 7) {
            switch (choise) {
                case 1:
                    mission.setStatus("Planning Phase");
                    break;
                case 2:
                    mission.setStatus("Departed Earth");
                    break;
                case 3:
                    mission.setStatus("Landed on Mars");
                    break;
                case 4:
                    mission.setStatus("Mission in progress");
                    break;
                case 5:
                    mission.setStatus("Returned to Earth");
                    break;
                case 6:
                    mission.setStatus("VMission Completed");
                    break;
            }
        }
        missionEditMenu(select, mission);
    }

    // 11.
    private void showOverallInformation(Mission mission) {
        StringBuilder sb = new StringBuilder();
        sb.append(mission.displayMission());
        int editSelect;
        do {
            System.out.println(sb.toString());
            editSelect = inputInt("Please choose 0 to go back", sb.toString());
        } while (editSelect != 0);

        missionCreateMenu(mission);
    }


    /**
     * nevigates the delete option to the right method
     */

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
            case 8:
                deleteJob(select, mission);
                break;
            case 9:
                deleteCargoRequirement(select, mission);
                break;
            case 10:
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

        deleteCountriesAllowedOneByOne(select, mission);
        missionEditMenu(select, mission);
    }

//     delete countries allowed one by one.
    public void deleteCountriesAllowedOneByOne(int select, Mission mission) {
        System.out.println("Country delete menu: ");
        for (int i = 0; i < mission.getCountriesAllowed().size(); i++) {
            System.out.println("Press " + (i + 1) + " to delete: " + mission.getCountriesAllowed().get(i));
        }

        if (mission.getCountriesAllowed().size() != 0)
            System.out.println("Press " + (mission.getCountriesAllowed().size() + 1) + " to delete all");
        else
            System.out.println("Nothing to delete");

        int choise = valueSelect(0, mission.getCountriesAllowed().size() + 1);
        if (choise == 0) {
            missionEditMenu(select, mission);
        } else if (0 < choise & choise < mission.getCountriesAllowed().size() + 1) {
            mission.getCountriesAllowed().remove(choise - 1 );
        } else if (choise == mission.getCountriesAllowed().size() + 1) {
            mission.getCountriesAllowed().clear();
        }

    }


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


    public void deleteJob(int select, Mission mission){
        StringBuilder str = new StringBuilder();
        if (null != mission.getJob()) {
            for (int i = 0; i < mission.getJob().size(); i++)
                str.append( "Press " + (i + 1) + " to delete: " +  mission.getJob().get(i).getJobName() + "\n");
        } else
            str.append("There is no job set");
        str.append("Press 0 to go back");
        System.out.println(str.toString());
        int editSelect = inputInt("Select your option");
        while (editSelect < 0 || editSelect > mission.getJob().size()) {
            editSelect = inputInt("Please select an right option");
        }

        if (editSelect == 0) {
            System.out.println(displayHeader(8, mission));
            missionEditMenu(editSelect, mission);
        }  else {
            mission.getJob().remove(editSelect - 1);
        }
        missionEditMenu(select, mission);
    }


    public void deleteCargoRequirement(int select, Mission mission){
        mission.setCargoRequirement(null);
        missionEditMenu(select, mission);
    }


    public void deleteStatus(int select, Mission mission){
        mission.setStatus(null);
        missionEditMenu(select, mission);
    }



    /**
     * displays choise with message for integer select.
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
     * inserts user integer properly
     */
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

    /**
     * inserts user String properly
     */

    public String inputString(String displayMessage) {
        System.out.println(displayMessage);
        Scanner scan = new Scanner(System.in);
        String temp = scan.nextLine();
//        scan.closea();
        return temp;
    }


    /**
     * inserts user value properly
     */

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

    /**
     * inserts date properly
     */

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
     * Reads the mission data from mission.csv
     */
    public void readMission() {
        ReadMission readMission = new ReadMission();
        ArrayList<Mission> missions = readMission.readMission();

        listOfMission = missions;
    }

    public void feature2(int missionSelected){
        boolean check = true;
        while (check) {
            GetShuttle getShuttle = new GetShuttle();
            ArrayList<String[]> shuttleSelected = getShuttle.readShuttle();
            Shuttle shuttle = getShuttle.selectShuttle(shuttleSelected);
            listOfMission.get(missionSelected).setShuttle(shuttle);

            EmploymentFastSystem employmentFastSystem = new EmploymentFastSystem();
            employmentFastSystem.selectCriEntry(listOfMission.get(missionSelected));
        }
    }





}
