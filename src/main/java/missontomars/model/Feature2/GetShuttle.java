package main.java.missontomars.model.Feature2;

import java.io.BufferedReader;
import java.io.FileReader;

public class GetShuttle {
    public void readShuttle(){
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
