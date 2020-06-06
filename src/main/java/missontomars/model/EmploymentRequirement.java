package main.java.missontomars.model;

public class EmploymentRequirement {
    int numberEmployeeRequired;
    String jobTitle;

    public EmploymentRequirement() {
        this.numberEmployeeRequired = 0;
    }

    public EmploymentRequirement(int numberEmployeeRequired, String jobTitle) {
        this.numberEmployeeRequired = numberEmployeeRequired;
        this.jobTitle = jobTitle;
    }



    public int getNumberEmployeeRequired() {
        return numberEmployeeRequired;
    }

    public void setNumberEmployeeRequired(int numberEmployeeRequired) {
        this.numberEmployeeRequired = numberEmployeeRequired;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String displayJobTitles() {
        StringBuilder sb = new StringBuilder();

        // display job name
        sb.append("\t Job title: " + jobTitle + ", ");

        // display job description
        sb.append("Number of employee required: " + numberEmployeeRequired);

        return sb.toString();
    }

}
