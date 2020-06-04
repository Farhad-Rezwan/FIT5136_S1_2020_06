import main.java.missontomars.control.MissionToMars;
import main.java.missontomars.model.Mission;

import static main.java.missontomars.control.MissionToMars.login;

public class Feature_1_test {

    public static void main(String ...args) {
        MissionToMars missionToMars = new MissionToMars();
        System.out.println("hellow form mission to mars");

        Mission m = new Mission();
        missionToMars.login();
        missionToMars.missionCreateMenu(m);



    }
}
