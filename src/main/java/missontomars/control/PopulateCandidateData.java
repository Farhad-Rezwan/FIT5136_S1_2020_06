package main.java.missontomars.control;

import main.java.missontomars.model.Candidate;
import main.java.missontomars.model.SelectCandidates;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PopulateCandidateData {
    private ArrayList<Candidate> listOfCandidates;
    public PopulateCandidateData() {

    }



    public ArrayList<Candidate> populateDataCandidate() {


//        candidate 1;
        ArrayList<String> allergies = new ArrayList<>();
        allergies.add("THis alergy");
        ArrayList<String> foodPreference  = new ArrayList<>();
        foodPreference.add("THis pref");
        ArrayList<String> qualification  = new ArrayList<>();
        qualification.add("THis qua");
        ArrayList<String> occupation  = new ArrayList<>();
        occupation.add("THis occu");
        ArrayList<String> languagesSpoken  = new ArrayList<>();
        languagesSpoken.add("THis lang");
        ArrayList<Integer> workExperience  = new ArrayList<>();
        workExperience.add(12);

        Candidate candidate = new Candidate(12, "Farhad", "21212", "Melbuorne", "1212",
                "Ausgtraliana", "Identiif", "G", allergies, foodPreference, qualification, occupation, languagesSpoken
                , workExperience, "Health rec", "Crim", "Comp skill");


        //        candidate 2;
        ArrayList<String> allergies2 = new ArrayList<>();
        allergies2.add("THis alergy");
        ArrayList<String> foodPreference2  = new ArrayList<>();
        foodPreference2.add("THis pref");
        ArrayList<String> qualification2  = new ArrayList<>();
        qualification2.add("THis qua");
        ArrayList<String> occupation2  = new ArrayList<>();
        occupation2.add("THis occu");
        ArrayList<String> languagesSpoken2  = new ArrayList<>();
        languagesSpoken2.add("THis lang");
        ArrayList<Integer> workExperience2 = new ArrayList<>();
        workExperience2.add(12);

        Candidate candidate2 = new Candidate(12, "Swapnil", "21212"
                , "Melbuorne", "1212"
                , "Ausgtraliana", "Identiif"
                , "G", allergies2, foodPreference2, qualification2, occupation2, languagesSpoken2
                , workExperience2, "Health rec", "Crim", "Comp skill");






        //        candidate 3;
        ArrayList<String> allergies3 = new ArrayList<>();
        allergies3.add("THis alergy");
        ArrayList<String> foodPreference3  = new ArrayList<>();
        foodPreference3.add("THis pref");
        ArrayList<String> qualification3  = new ArrayList<>();
        qualification3.add("THis qua");
        ArrayList<String> occupation3  = new ArrayList<>();
        occupation3.add("THis occu");
        ArrayList<String> languagesSpoken3  = new ArrayList<>();
        languagesSpoken3.add("THis lang");
        ArrayList<Integer> workExperience3 = new ArrayList<>();
        workExperience3.add(12);

        Candidate candidate3 = new Candidate(12, "Louis", "21212"
                , "Melbuorne", "1212"
                , "Ausgtraliana", "Identiif"
                , "G", allergies3, foodPreference3, qualification3, occupation3, languagesSpoken3
                , workExperience3, "Health rec", "Crim", "Comp skill");



        ArrayList<Candidate> candidateList = new ArrayList<>();


        candidateList.add(candidate);
        candidateList.add(candidate2);
        candidateList.add(candidate3);

//        SelectCandidates sc = new SelectCandidates();
//
//        sc.confirmCandidates(candidateList);

        return candidateList;


    }
}
