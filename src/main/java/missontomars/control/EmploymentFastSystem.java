package main.java.missontomars.control;

import main.java.missontomars.model.Mission;
import main.java.missontomars.model.Shuttle;

import java.util.Scanner;

// when we come from feature 2 we join here in this class
public class EmploymentFastSystem {
    public EmploymentFastSystem(){

    }

    public void selectCriEntry(Mission mission){
        boolean check = true;
        while (check) {
            int select = inputInt("Shuttle selected"
                    + "\nPress 1 to acquire the employment requirements"
                    + "\nPress 2 to selection criteria setting"
                    + "\nPress 3 to view selected shuttle"
                    + "\nPress 4 to select candidates"
                    + "\nPress 0 to back to change a shuttle");
            select = valueSelect(0, 3, select);
            if (select == 2) {
                EmployFast employFast = new EmployFast();
                employFast.criteriaMenu(mission);
            } else if (select == 1) {
                displayEmp(mission);
            } else if (select == 3){
                displayShuttle(mission.getShuttle());
            }
            else if (select == 0){
                check = false;
            }
        }

    }

    public void selectNBestCandidate(Mission misson){

    }

    private void displayEmp(Mission mission){
        if (mission.getJob().size() == 0){
            System.out.println("No employment requirement information");
        }
        else {
            for (int i = 0; i < mission.getJob().size(); i++) {
                System.out.println((i + 1) + ": " + mission.getJob().get(i).getJobName());
            }
        }
        int select = inputInt("Press 0 to go back");
        select = valueSelect(0,0,select);
    }

    private void displayShuttle(Shuttle shuttle){
        System.out.println("Shuttle id: " + shuttle.getId()
                + "\nShuttle name: " + shuttle.getShuttleName()
                + "\nShuttle manufacturing year: " + shuttle.getManufacturingYear()
                + "\nShuttle fuel capacity: " + shuttle.getFuelCapacity()
                + "\nShuttle travel speed: " + shuttle.getTravelSpeed()
                + "\nShuttle origin: " + shuttle.getOrigin());
        int select = inputInt("Press 0 to go back");
        select = valueSelect(0,0,select);
    }

    private int valueSelect(int min, int max, int select) {
        while (!(min <= select & select <= max)) {
            select = inputInt("Please select the right option");
        }
        return select;
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

}
