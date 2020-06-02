package main.java.missontomars.control;

import main.java.missontomars.model.Mission;
import main.java.missontomars.model.SelectionCriteria;
import main.java.missontomars.model.Shuttle;

import java.util.ArrayList;

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



}
