import main.java.missontomars.control.MissionToMars;
import main.java.missontomars.model.Cargo;
import main.java.missontomars.model.CargoRequirement;
import main.java.missontomars.model.Job;
import main.java.missontomars.model.Mission;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static main.java.missontomars.control.MissionToMars.login;

public class Feature_1_test {

    public static void main(String ...args) {
        MissionToMars missionToMars = new MissionToMars();
        System.out.println("hello form mission to mars");

        Mission m = new Mission();
        Mission k = new Mission();
        k.setMissionName("Farhad");

        CargoRequirement cr = new CargoRequirement();
        ArrayList<String> cf = new ArrayList<>();
        cf.add("mission");
        cf.add("other mission");
        cr.setCargoFor(cf);


        ArrayList<String> req = new ArrayList<>();

        req.add("Concrete");
        req.add("Dessert");

        cr.setCargoRequired(req);
        cr.setCargoRequired("Chicken");
        cr.setCargoQuantity(100);

        ArrayList<Cargo> cargos = new ArrayList<>();
        cargos.add(new Cargo(10, "Pasta", 200));
        cargos.add(new Cargo(20, "Nuduls", 200));
        cr.setCargoList(cargos);


        ArrayList<String> countries = new ArrayList<>();
        countries.add("Bangladesh");
        countries.add("Australia");
        countries.add("India");

        k.setCountriesAllowed(countries);

        k.setCargoRequirement(cr);

        Job job = new Job();
        job.setJobName("This job");
        job.setJobDescription("This job description");
        Job job2 = new Job();
        job2.setJobName("Another job");
        job2.setJobDescription("Another job description");

        k.setJob(job);
        k.setJob(job2);

        ArrayList<Mission> list = new ArrayList<>();
        list.add(k);
        missionToMars.setListOfMission(list);



//        missionToMars.login();
        missionToMars.missionCreateMenu(m);



    }
}
