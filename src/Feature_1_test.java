import main.java.missontomars.control.MissionToMars;
import main.java.missontomars.model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static main.java.missontomars.control.MissionToMars.login;

public class Feature_1_test {

    public static void main(String... args) {

        login();
        MissionToMars mtm = new MissionToMars();
        mtm.readMission();
        mtm.idToEditView();


    }

}


