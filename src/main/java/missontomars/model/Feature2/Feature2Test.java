package main.java.missontomars.model.Feature2;

import main.java.missontomars.model.Shuttle;

import java.util.ArrayList;

public class Feature2Test {
    public static void main(String... args) {
        GetShuttle getShuttle = new GetShuttle();
        ArrayList<String[]> shuttleSelected = getShuttle.readShuttle();
        Shuttle shuttle = getShuttle.selectShuttle(shuttleSelected);
    }
}
