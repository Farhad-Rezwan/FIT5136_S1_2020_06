package main.java.missontomars.model.Feature2;

import main.java.missontomars.model.Shuttle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetShuttle {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shuttle;
    }

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
        Shuttle shuttle = new Shuttle(Integer.parseInt(shuttle1[0]),shuttle1[1],Integer.parseInt(shuttle1[2]),
                Integer.parseInt(shuttle1[3]), Integer.parseInt(shuttle1[4]),
                Integer.parseInt(shuttle1[5]),Integer.parseInt(shuttle1[6]),shuttle1[7]);
        return shuttle;
    }

    public void readEmployee(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("shuttle.csv"));//换成你的文件名
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line;
            while((line=reader.readLine())!=null){
                String[] item = line.split(",");
                StringBuilder line1 = new StringBuilder();
                for (String column : item) {
                    line1.append(column).append("      ");
                }
                //String last = item[item.length-1];
                System.out.println(line1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
