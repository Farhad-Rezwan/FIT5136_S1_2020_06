package main.java.missontomars.control;

import main.java.missontomars.model.*;
import main.java.missontomars.model.Feature2.GetShuttle;

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

        //Feature2 starts here
        GetShuttle getShuttle = new GetShuttle();
        ArrayList<String[]> shuttleSelected = getShuttle.readShuttle();
        Shuttle shuttle = getShuttle.selectShuttle(shuttleSelected);
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
                + "\nPress 0 to back"
                + "\n");
        int select = inputInt("Please select an option");
        select = valueSelect(0,11,select);
        if (select == 0) {
            idToEditView();
        } else if (0 < select & select < 11) {
            missionEditMenu(select, mission);
        } else if (select == 11) {
            showOverallInformation(mission);
        }
    }


    public void missionEditMenu(int select, Mission mission) {

        System.out.println(displayHeader(select, mission));
        int editSelect = inputInt("Press 1 to add" + "\nPress 2 to delete" + "\nPress 0 to go back");
        while (editSelect < 0 || editSelect > 2) {
            editSelect = inputInt("Please select an right option");
        }

        if (editSelect == 0) {
            missionCreateMenu(mission);
        }

        if (editSelect == 1) {
            if (select == 8){
                addJob(select, mission);
            }

            //System.out.println(displayHeader(select, mission));
            //addEntries(select, mission);
        }

        if (editSelect == 2) {
            deleteEntries(select, mission);
        }

        System.out.println(displayHeader(select, mission));
    }

    private void addJob(int select, Mission mission){
        String jobName = inputString("Enter job name");
        String jobDes = inputString("Enter job description");
        Job newJob = new Job();
        newJob.setJobName(jobName);
        newJob.setJobDescription(jobDes);
        int titleSelect = inputInt("Press 1 to add job title"
                + "\nPress 0 to go back");
        titleSelect = valueSelect(0,1,titleSelect);
        if (titleSelect == 1){
           addJobTitle(select,mission, newJob);
        }
        else if(titleSelect == 0){
            ArrayList<Job> newJobs = mission.getJob();
            newJobs.add(newJob);
            mission.setJob(newJobs);
            missionEditMenu(select,mission);
        }

    }

    public void addJobTitle(int select, Mission mission, Job job) {
        boolean addMenu = true;
        while (addMenu) {
            System.out.println("Job:" + job.getJobName());
            job.displayTitle();
            int option = inputInt("Press 1 to add a new title"
                    + "\nPress 2 to delete title" + "\nPress 0 to go back");
            option = valueSelect(0, 2, option);
            if (option == 1) {
                job.addTitle();
            } else if (option == 0) {
                addMenu = false;
            } else if (option == 2) {
                if(job.getEmploymentRequirements().size() > 0) {
                    job.deleteTitle();
                }
                else if (job.getEmploymentRequirements().size() == 0){
                    System.out.println("No title to delete");
                }
            }
        }
        mission.getJob().add(job);
        missionEditMenu(select, mission);
    }

    private int valueSelect(int min, int max, int select) {
        while (!(min <= select & select <= max)) {
            select = inputInt("Please select the right option");
        }
        return select;
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
                if (mission.getJob().size() > 0){
                    for (int i = 0; i < mission.getJob().size(); i++){
                        System.out.println( (i + 1) + ": " + mission.getJob().get(i).getJobName());
                    }
                }
                break;
            case 9:
                if (null != mission.getCargoRequirement()) {
                    str.append(mission.getCargoRequirement().displayCargoRequirement() + " month");
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
                addJob(mission);
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

    // 6.
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



    // 8.

    private void jobsShowView(Mission mission) {
        int numberOfJob = mission.getJob().size();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numberOfJob; i++) {
            sb.append((i + 1) + "： " + mission.getJob().get(i).getJobName() + "\n");
        }
        System.out.println(sb.toString());

        int jobSelect = inputInt("Select job Number to edit", sb.toString());
        while (jobSelect < 1 || jobSelect > numberOfJob) {
            System.out.println(" ");
            System.out.println(sb.toString());
            jobSelect = inputInt("Please choose the right option", sb.toString());

        }

        addJob(listOfMission.get(jobSelect - 1));
        System.out.println("Selected");

    }


//    private void addJob2(Mission mission) {
//        getJobId(mission);
//
//        if (null != job) {
//            System.out.print("Selected Job :" + job.getJobName()
//                    + "\nPress 1 for job name"
//                    + "\nPress 2 for job description"
//                    + "\nPress 3 for employment requirement"
//                    + "\nPress 0 to go back");
//            int select = valueSelect(0, 4);
//            if (select == 0) {
//                missionEditMenu(select, mission);;
//            } else if (0 < select & select < 3) {
////            jobEditMenu(select, job);
//            }
//
//            missionEditMenu(select, mission);
//
//        } else {
//            missionEditMenu(0, mission);
//        }
//
//
//    }


    private void addJob(Mission mission) {
        /*StringBuilder str = new StringBuilder();
        if (null != mission.getJob()) {
            for (int i = 0; i < mission.getJob().size(); i++)
                str.append( "Press " + (i + 1) + " to edit: " +  mission.getJob().get(i).getJobName() + "\n");
        } else
            str.append("There is no job set");
        str.append("Press 0 to go back");
        System.out.println(str.toString());*/
        int editSelect = inputInt("Select your option");
        while (editSelect < 0 || editSelect > 2) {
            editSelect = inputInt("Please select an right option");
        }
        if (editSelect == 0) {
            missionEditMenu(editSelect, mission);
        } else {
            jobEditMenu(editSelect, mission.getJob().get(editSelect - 1), mission);
        }


    }

    private void jobEditMenu(int select, Job job, Mission mission) {

        System.out.println(display(select, mission, job));

        int editSelect = inputInt("Press 1 to add" + "\nPress 2 to delete" + "\nPress 0 to go back");
        while (editSelect < 0 || editSelect > 2) {
            editSelect = inputInt("Please select an right option");
        }

        if (editSelect == 0) {
            ;
        }

        if (editSelect == 1) {
            //System.out.println(displayHeaderJob(select, job));
            addJobEntries(select, job);
        }

        if (editSelect == 2) {
            deleteJobEntries(select, job);
        }

        //System.out.println(displayHeaderJob(select, job));
    }

    private String display(int select, Mission mission, Job job) {

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
                        str.append("  " + (i + 1) + ": " + job.getEmploymentRequirements().get(i).displayJobTitles());
                } else {
                    str.append("There is no countries allowed yet");
                }
                break;
            case 8:
                if (mission.getJob().size() > 0){
                    for (int i = 0; i < mission.getJob().size(); i++){
                        System.out.println( (i + 1) + ": " + mission.getJob().get(i).getJobName());
                    }
                }

        }
        return str.toString();
    }

    private void addJobEntries(int select, Job job) {

        switch (select) {
            case 1:
                addJobName(select, job);
                break;
            case 2:
                addJobDescription(select, job);
                break;
            case 3:
                addEmploymentRequirement(select, job);
                break;
        }
    }

    private void addJobName(int select, Job job ) {

    }
    private void addJobDescription(int select, Job job ) {

    }

    private void addEmploymentRequirement (int select, Job job ) {

    }

    private void deleteJobEntries(int select, Job job ) {
//        switch (select) {
//            case 1:
//                deleteMissionName(select, job );
//                break;
//            case 2:
//                deleteMissionDescription(select, job);
//                break;
//            case 3:
//                deleteMissionOrigin(select, job);
//                break;
//            case 4:
//                deleteCountriesAllowed(select, job);
//                break;
//        }

    }


    //  9.
    private void addCargoRequirement(int select, Mission mission){

    }
    // 10.
    private void addStatus(int select, Mission mission) {

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
//        mission.setCountriesAllowedAllowed((String) null); // or

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

        /*int choise = valueSelect(0, mission.getCountriesAllowed().size() + 1);
        if (choise == 0) {
            missionEditMenu(select, mission);
        } else if (0 < choise & choise < mission.getCountriesAllowed().size() + 1) {
            mission.getCountriesAllowed().remove(choise - 1 );
        } else if (choise == mission.getCountriesAllowed().size() + 1) {
            mission.getCountriesAllowed().clear();
        }*/

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
//    public void d/                case 8: deleteMissionType(select, mission){
//    missionEditMenu(select, mission);}

    // need change?
    public void deleteJob(int select, Mission mission){
        displayHeader(select,mission);
        int deleteOption = inputInt("Please select the number you want to delete");
        deleteOption = valueSelect(1,mission.getJob().size(),deleteOption);
        mission.getJob().remove((deleteOption - 1));
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
            select = inputInt("Please select the right option");
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
