package main.java.missontomars.model;

import java.util.ArrayList;

public class Job {
    String jobName;
    String jobDescription;
    ArrayList<EmploymentRequirement> employmentRequirements;

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
}
