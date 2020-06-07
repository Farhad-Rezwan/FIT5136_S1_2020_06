package main.java.missontomars.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectCandidates {

    public SelectCandidates() {
    }

    /**
     * Method which ask the candidates to confirm or reject
     * @param originalCandidates list of the candidate to make decision
     * @return A list of confirmed candidates
     */
    public static List<Candidate> confirmCandidates(List<Candidate> originalCandidates) {
        Scanner scanner = new Scanner(System.in);
        List<Candidate> confirmedCandidates = new ArrayList<>();
        for(Candidate candidate : originalCandidates) {
            System.out.println(String.format("Congrats %s, you have been selected on mission to mars\n",candidate.getName()));
            System.out.println("Do you accept the mission ? Y/N");
            if(scanner.nextLine().equalsIgnoreCase("Y")) {
                confirmedCandidates.add(candidate);
            }
            System.out.println("\n******************************\n");
        }

        if(confirmedCandidates.size() == originalCandidates.size()) {
            System.out.println("All candidates have been confirmed and ready to go on a mission");
        } else {
            System.out.println("Sorry there are some candidates to refused to go on a mission");
            System.out.println("Consider other candidates");
        }
        return confirmedCandidates;
    }

}
