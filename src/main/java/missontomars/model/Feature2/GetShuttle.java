package main.java.missontomars.model.Feature2;

import main.java.missontomars.model.Shuttle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetShuttle {
    /**
     * Method which read shuttle information from file
     * @return A arrayList of the shuttle information
     */
    public ArrayList<String[]> readShuttle(){
        ArrayList<String[]> shuttle = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("shuttle.csv"));
            reader.readLine();
            String line;
            while((line=reader.readLine())!=null){
                String[] item = line.split(",");
                StringBuilder line1 = new StringBuilder();
                for (String column : item) {
                    line1.append(column).append("      ");
                }
                //String last = item[item.length-1];
                System.out.println(line1);
                shuttle.add(item);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shuttle;
    }

    /**
     * Method which select the shuttle
     * @param shuttleSelected A arrayList of the shuttle information from the file
     * @return A selected shuttle
     */
    public Shuttle selectShuttle(ArrayList<String[]> shuttleSelected){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the shuttle id for mission");
        String shuttleId = sc.nextLine();
        String[] shuttle1 = new String[8];
        for (String[] strings : shuttleSelected) {
            if (shuttleId.equals(strings[0])) {
                for (int j = 0; j < 8; j++) {
                    shuttle1[j] = strings[j];
                }
            }
        }
        Shuttle shuttle = new Shuttle(Integer.parseInt(shuttle1[0]),shuttle1[1],shuttle1[2],
                Integer.parseInt(shuttle1[3]), Integer.parseInt(shuttle1[4]),
                Integer.parseInt(shuttle1[5]),Integer.parseInt(shuttle1[6]),shuttle1[7]);
        System.out.println(shuttle.getId() + " " + shuttle.getShuttleName() + " is selected");
        return shuttle;
    }

}