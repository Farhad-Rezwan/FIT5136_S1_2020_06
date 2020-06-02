package main.java.missontomars.model;

public class Shuttle {
    private int id;
    private String shuttleName;
    private int manufacturingYear;
    private int fuelCapacity;
    private int passengerCapacity;
    private int cargoCapacity;
    private int travelSpeed;
    private String origin;

    public Shuttle(int id, String shuttleName, int manufacturingYear, int fuelCapacity, int passengerCapacity,
                   int cargoCapacity, int travelSpeed, String origin) {
        this.id = id;
        this.shuttleName = shuttleName;
        this.manufacturingYear = manufacturingYear;
        this.fuelCapacity = fuelCapacity;
        this.passengerCapacity = passengerCapacity;
        this.cargoCapacity = cargoCapacity;
        this.travelSpeed = travelSpeed;
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShuttleName() {
        return shuttleName;
    }

    public void setShuttleName(String shuttleName) {
        this.shuttleName = shuttleName;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public int getTravelSpeed() {
        return travelSpeed;
    }

    public void setTravelSpeed(int travelSpeed) {
        this.travelSpeed = travelSpeed;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
