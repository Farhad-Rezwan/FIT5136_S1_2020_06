package main.java.missontomars.model;

import java.util.ArrayList;

public class Job {
    String jobName;
    String jobDescription;
    ArrayList<EmploymentRequirement> employmentRequirements;

    public Job() {
        this.jobName = "";
        this.jobDescription = "";
        employmentRequirements = new ArrayList<>();
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public ArrayList<EmploymentRequirement> getEmploymentRequirements() {
        return employmentRequirements;
    }

    public void setEmploymentRequirements(ArrayList<EmploymentRequirement> employmentRequirements) {
        this.employmentRequirements = employmentRequirements;
    }

    public void setEmploymentRequirements(int index, EmploymentRequirement employmentRequirement) {
        this.employmentRequirements.add(index, employmentRequirement);
    }

    public void setEmploymentRequirements(EmploymentRequirement employmentRequirement) {
        this.employmentRequirements.add(employmentRequirement);
    }

    public String displayJob() {
        StringBuilder sb = new StringBuilder();
        sb.append("Job information: \n \t");

        // display job name
        sb.append("\t \tjob name: " + jobName + "\n \t");

        // display job description
        sb.append("\t \tjob description: " + jobDescription + "\n \t");

        // display employment requirement
        for (int i = 0; i < employmentRequirements.size(); i++) {
            sb.append( "\n \t \t \t" + (i + 1) + ": " + employmentRequirements.get(i).displayJobTitles());
        }
        sb.append("\n");


        return sb.toString();
    }
}
