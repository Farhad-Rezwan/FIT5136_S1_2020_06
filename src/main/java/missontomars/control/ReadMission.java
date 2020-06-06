package main.java.missontomars.control;


import main.java.missontomars.model.EmploymentRequirement;
import main.java.missontomars.model.Job;
import main.java.missontomars.model.Mission;
import main.java.missontomars.model.SelectionCriteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadMission {
    public Mission readShuttle() {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Mission mission = null;
        try {
            BufferedReader reader2 = new BufferedReader(new FileReader("mission.csv"));
            reader2.readLine();
            String line;
            ArrayList<SelectionCriteria> selectionCriteria = new ArrayList<>();
            ArrayList<Job> jobList = new ArrayList<>();
            ArrayList<EmploymentRequirement> employmentRequirement = new ArrayList<>();
            while ((line = reader2.readLine()) != null) {
                String[] item = line.split(",");
                StringBuilder line1 = new StringBuilder();
                for (int i = 0; i < item.length; i += 5) {
                    mission.setId(Integer.parseInt(item[i]));
                    mission.setMissionName(item[i + 1]);
                    mission.setLaunchDate(fmt.parse(item[i + 2]));
                    mission.setMissionOrigin(item[i + 3]);
                    ArrayList<String> country = new ArrayList<>();
                    String[] s = item[i + 4].split(".");
                    country.addAll(Arrays.asList(s));
                    mission.setCountriesAllowed(country);
                    mission.setDuration(Integer.parseInt(item[i + 5]));
                    mission.setMissionType(item[i + 6]);
                    mission.setMissionDescription(item[i + 9]);
                    String[] s3 = item[i+10].split(".");
                    String[] s4 = item[i+11].split(".");
                    for(int j=0; j<s3.length; j++){
                        EmploymentRequirement employmentRequirement1 = new EmploymentRequirement(Integer.parseInt(s3[j]),s4[j]);
                        employmentRequirement.add(employmentRequirement1);
                    }
                    String[] s1 = item[i + 7].split(".");
                    String[] s2 = item[i + 8].split(".");
                    for(int j=0; j<s1.length; j++){
                        Job job1 = null;
                        job1.setJobName(s1[j]);
                        job1.setJobDescription(s2[j]);
                        jobList.add(job1);
                    }
                    mission.setJob(jobList);
                    mission.setDestinationAddress(item[i+22]);
                    mission.setStatus(item[i+23]);
                }
            }
            reader2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mission;
    }
}
