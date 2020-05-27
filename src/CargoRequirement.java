import java.util.ArrayList;
import java.util.List;

public class CargoRequirement {
    private ArrayList<String> cargoFor;
    private ArrayList<Cargo> cargoRequired;
    private int cargoQuantity;
    private ArrayList<Cargo> cargoList;

    public CargoRequirement() {
    }

    public CargoRequirement(ArrayList<String> cargoFor, ArrayList<Cargo> cargoRequired, int cargoQuantity, ArrayList<Cargo> cargoList) {
        this.cargoFor = cargoFor;
        this.cargoRequired = cargoRequired;
        this.cargoQuantity = cargoQuantity;
        this.cargoList = cargoList;
    }

    public ArrayList<String> getCargoFor() {
        return cargoFor;
    }

    public void setCargoFor(ArrayList<String> cargoFor) {
        this.cargoFor = cargoFor;
    }

    public ArrayList<Cargo> getCargoRequired() {
        return cargoRequired;
    }

    public void setCargoRequired(ArrayList<Cargo> cargoRequired) {
        this.cargoRequired = cargoRequired;
    }

    public int getCargoQuantity() {
        return cargoQuantity;
    }

    public void setCargoQuantity(int cargoQuantity) {
        this.cargoQuantity = cargoQuantity;
    }

    public ArrayList<Cargo> getCargoList() {
        return cargoList;
    }

    public void setCargoList(ArrayList<Cargo> cargoList) {
        this.cargoList = cargoList;
    }
}
