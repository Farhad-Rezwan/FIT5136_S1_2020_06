package main.java.missontomars.model;



import java.util.ArrayList;
import java.util.List;

public class Mission {
    int id;
    String missionName;
    String missionDescription;
    String missionOrigin;
    List<String> countriesAllowed;
    String  launchDate;
    List<String> destinationAddress;
    int duration;
    String status;
    List<String> missionType;
    ArrayList<Job> job;
    CargoRequirement cargoRequirement;
    private SelectionCriteria selectionCriteria;

    public Mission() {
      selectionCriteria = new SelectionCriteria();

    }

    public Mission(int id, String missionName, String missionDescription,
                   String missionOrigin, List<String> countriesAllowed, String launchDate,
                   List<String> destinationAddress, int duration, String status,
                   List<String> missionType, ArrayList<Job> job, CargoRequirement cargoRequirement,
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

    public List<String> getCountriesAllowed() {
        return countriesAllowed;
    }

    public void setCountriesAllowed(List<String> countriesAllowed) {
        this.countriesAllowed = countriesAllowed;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public List<String> getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(List<String> destinationAddress) {
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

    public List<String> getMissionType() {
        return missionType;
    }

    public void setMissionType(List<String> missionType) {
        this.missionType = missionType;
    }

    public ArrayList<Job> getJob() {
        return job;
    }

    public void setJob(ArrayList<Job> job) {
        this.job = job;
    }

    public CargoRequirement getCargoRequirement() {
        return cargoRequirement;
    }

    public void setCargoRequirement(CargoRequirement cargoRequirement) {
        this.cargoRequirement = cargoRequirement;
    }
}
