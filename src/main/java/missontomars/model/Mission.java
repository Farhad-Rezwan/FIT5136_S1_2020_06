package main.java.missontomars.model;



//import sun.jvm.hotspot.opto.Phase;

import javax.print.attribute.standard.Destination;
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
    String destinationAddress;
    int duration;
    String status;
    String missionType;
    ArrayList<Job> job;
    CargoRequirement cargoRequirement;
    ArrayList<EmploymentRequirement> employmentRequirements;
    private SelectionCriteria selectionCriteria;
    Shuttle shuttle;

    public Mission() {
      selectionCriteria = new SelectionCriteria();
      missionType = "Planning Phase";
      countriesAllowed = new ArrayList<>();
      job = new ArrayList<>();
    }

    public Mission(int id, String missionName, String missionDescription,
                   String missionOrigin, ArrayList<String> countriesAllowed, Date launchDate,
                   String destinationAddress, int duration, String status,
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

    public ArrayList<EmploymentRequirement> getEmploymentRequirements() {
        return employmentRequirements;
    }

    public void setEmploymentRequirements(ArrayList<EmploymentRequirement> employmentRequirements) {
        this.employmentRequirements = employmentRequirements;
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
        if (null != countriesAllowed)
        this.countriesAllowed = countriesAllowed;
    }

    public void setCountriesAllowed(String countryAllowed) {
        if (null != countriesAllowed) {
            this.countriesAllowed.add(countryAllowed);
        }
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    /**
     * Method which set the information of destination
     * @param destinationAddress A string of destination address
     */
    public void setDestinationAddress(String destinationAddress) {
        if (null != destinationAddress) {
            ArrayList<String> missionDestinationList = new ArrayList<>();
            missionDestinationList.add("INSIGHT");
            missionDestinationList.add("PHOENIX");
            missionDestinationList.add("VIKING 1");
            missionDestinationList.add("PATHFINDER");
            missionDestinationList.add("OPPORTUNITY");
            missionDestinationList.add("VIKING 2");
            missionDestinationList.add("CURIOSITY");
            missionDestinationList.add("SPIRIT");


            for (int i = 0; i < missionDestinationList.size(); i++) {
                if (destinationAddress.trim().toUpperCase().equals(missionDestinationList.get(i).trim().toUpperCase())) {
                    this.destinationAddress = missionDestinationList.get(i);
                    break;
                } else {
                    this.destinationAddress = null;
                }
            }
        } else {
            this.destinationAddress = null;
        }

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

    /**
     * Method which set mission status
     * @param status Mission status
     */
    public void setStatus(String status) {
        if (null != status) {
            ArrayList<String> statusList = new ArrayList<>();
            statusList.add("Planning Phase");
            statusList.add("Departed Earth");
            statusList.add("Landed on Mars");
            statusList.add("Mission in progress");
            statusList.add("Returned to Earth");
            statusList.add("Mission Completed");


            for (int i = 0; i < statusList.size(); i++) {
                if (status.trim().toUpperCase().equals(statusList.get(i).trim().toUpperCase())) {
                    this.status = statusList.get(i);
                    break;
                } else {
                    this.status = "Planning Phase";
                }
            }
        } else {
            this.status = "Planning Phase";
        }
    }

    public String getMissionType() {
        return missionType;
    }

    public void setMissionType(String missionType) {
        this.missionType = missionType;
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

    /**
     * Method which display the mission
     * @return A display string
     */
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

        sb.append("Mission destination address: " + destinationAddress);
//        sb.append("~" + "Mission job information: " + missionName);
        try {
            sb.append(cargoRequirement.displayCargoRequirement());
        } catch(Exception e) {}
        sb.append("Mission status: " + status + "\n");


        return sb.toString();
    }
    public Shuttle getShuttle() {
        return shuttle;
    }

    public void setShuttle(Shuttle shuttle) {
        this.shuttle = shuttle;
    }

}
