package main.java.missontomars.model;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mission {
    int id;
    String missionName;
    String missionDescription;
    String missionOrigin;
    ArrayList<String> countriesAllowed;
    Date launchDate;
    ArrayList<String> destinationAddress;
    int duration;
    String status;
    String missionType;
    ArrayList<Job> job;
    CargoRequirement cargoRequirement;
    private SelectionCriteria selectionCriteria;

    public Mission() {
      selectionCriteria = new SelectionCriteria();
      missionType = "Planning Phase";
    }

    public Mission(int id, String missionName, String missionDescription,
                   String missionOrigin, ArrayList<String> countriesAllowed, Date launchDate,
                   ArrayList<String> destinationAddress, int duration, String status,
                   String missionType, ArrayList<Job> job, CargoRequirement cargoRequirement,
                   SelectionCriteria selectionCriteria) {
        this.id = id;
        this.missionName = missionName;
        this.missionDescription = missionDescription;
        this.missionOrigin = missionOrigin;
        this.countriesAllowed = countriesAllowed;
        this.launchDate = launchDate;
        this.destinationAddress = destinationAddress;
        this.duration = duration;
        this.status = status;
        this.missionType = missionType;
        this.job = job;
        this.cargoRequirement = cargoRequirement;
        this.selectionCriteria = selectionCriteria;
    }

    public SelectionCriteria getSelectionCriteria() {
        return selectionCriteria;
    }

    public void setSelectionCriteria(SelectionCriteria selectionCriteria) {
        this.selectionCriteria = selectionCriteria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getMissionDescription() {
        return missionDescription;
    }

    public void setMissionDescription(String missionDescription) {
        this.missionDescription = missionDescription;
    }

    public String getMissionOrigin() {
        return missionOrigin;
    }

    public void setMissionOrigin(String missionOrigin) {
        this.missionOrigin = missionOrigin;
    }

    public ArrayList<String> getCountriesAllowed() {
        return countriesAllowed;
    }

    public void setCountriesAllowed(ArrayList<String> countriesAllowed) {
        this.countriesAllowed = countriesAllowed;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public ArrayList<String> getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(ArrayList<String> destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMissionType() {
        return missionType;
    }

    public ArrayList<Job> getJob() {
        return job;
    }

    public void setJob(ArrayList<Job> jobs) {
        this.job = jobs;
    }

    public void setJob(int index, Job job) {
        this.job.add(index, job);
    }

    public void setJob(Job job) {
        this.job.add(job);
    }

    public CargoRequirement getCargoRequirement() {
        return cargoRequirement;
    }

    public void setCargoRequirement(CargoRequirement cargoRequirement) {
        this.cargoRequirement = cargoRequirement;
    }


    public String displayMission() {
        StringBuilder sb = new StringBuilder();
        sb.append(" \n");

        sb.append("Mission name: " + missionName + "\n \t");
        sb.append("Mission description: " + missionDescription + "\n \t");
        sb.append("Mission origion: " + missionOrigin + "\n \t");
        try {
            sb.append("Countries allowed: ");
            for (int i = 0; i < countriesAllowed.size(); i++) {
                sb.append(countriesAllowed.get(i));
                if (i == countriesAllowed.size() -1) {
                    sb.append(". ");
                } else {
                    sb.append(", ");
                }
            }

        } catch (Exception e) {
            sb.append("null");
        }
        sb.append("\n \t");

        try {
            sb.append("Mission launch date: " + launchDate.toString());
        } catch (Exception e) {
            sb.append("Mission Launch Date: not assigned");
        }
        sb.append("\n \t");

//        sb.append("~" + "Mission destination address: " + launchDate);
//        sb.append("~" + "Mission job information: " + missionName);
        try {
            sb.append(cargoRequirement.displayCargoRequirement());
        } catch(Exception e) {}
        sb.append("Mission status: " + status + "\n");


        return sb.toString();
    }

}
