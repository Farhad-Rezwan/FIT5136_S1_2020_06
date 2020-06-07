package main.java.missontomars.model;

import main.java.missontomars.model.Cargo;

import java.util.ArrayList;
import java.util.List;

public class CargoRequirement {
    private ArrayList<String> cargoFor;
    private ArrayList<String> cargoRequired;
    private int cargoQuantity;
    private ArrayList<Integer> quantity;
    private ArrayList<Cargo> cargoList;

    public CargoRequirement() {
        this.cargoFor = new ArrayList<>();
        this.cargoRequired = new ArrayList<>();
        this.cargoList = new ArrayList<>();
        this.cargoQuantity = 0;
    }

    public CargoRequirement(ArrayList<String> cargoFor, ArrayList<String> cargoRequired, int cargoQuantity, ArrayList<Cargo> cargoList) {
        this.cargoFor = cargoFor;
        this.cargoRequired = cargoRequired;
        this.cargoQuantity = cargoQuantity;
        this.cargoList = cargoList;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<Integer> quantity) {
        this.quantity = quantity;
    }

    public ArrayList<String> getCargoFor() {
        return cargoFor;
    }

//    public void setCargoFor(ArrayList<String> cargoFor) {
//        this.cargoFor = cargoFor;
//    }

        public void setCargoFor(ArrayList<String> cargoFor) {
        ArrayList<String> cargoForArrayPredefinedList = new ArrayList<>();
        cargoForArrayPredefinedList.add("Mission");
        cargoForArrayPredefinedList.add("Journey");
        cargoForArrayPredefinedList.add("Other mission");


        for (String singleCargoForParam: cargoFor) {
            for (int i = 0; i < cargoForArrayPredefinedList.size(); i++) {
                if (singleCargoForParam.trim().toUpperCase().equals(cargoForArrayPredefinedList.get(i).trim().toUpperCase())) {
                    this.cargoFor.add(cargoForArrayPredefinedList.get(i));
                }
            }

//            for (String cargoForPredefined: cargoForArrayPredefinedList) {
//                if (cargoForPredefined.trim().toUpperCase().contains(singleCargoForParam.trim().toUpperCase())) {
//                    this.cargoFor.add(cargoForPredefined);
//                }
//            }
        }
        this.cargoFor = cargoFor;
    }

    public ArrayList<String> getCargoRequired() {
        return cargoRequired;
    }

    public void setCargoRequired(ArrayList<String> cargoRequired) {
        this.cargoRequired = cargoRequired;
    }

    public void setCargoRequired(int index, String cargo) {
        this.cargoRequired = cargoRequired;
    }

    public void setCargoRequired(String cargo) {
        this.cargoRequired = cargoRequired;
    }

    public ArrayList<Cargo> getCargoList() {
        return cargoList;
    }

    public void setCargoList(ArrayList<Cargo> cargoList) {
        this.cargoList = cargoList;
    }

    public void setCargoList(int index, Cargo cargo) {
        this.cargoList.add(index, cargo);
    }

    public void setCargoList(Cargo cargo) {
        this.cargoList.add(cargo);
    }

    public int getCargoQuantity() {
        return cargoQuantity;
    }

    public void setCargoQuantity(int cargoQuantity) {
        this.cargoQuantity = cargoQuantity;
    }

    public String displayCargoRequirement() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cargo Requirement: \n \t");

        // display string for cargo for
        sb.append("\tCargo for: ");
        for (int i = 0; i < cargoFor.size(); i++) {
            sb.append(cargoFor.get(i));
            if (i == cargoFor.size() -1) {
                sb.append(". ");
            } else {
                sb.append(", ");
            }
        }
        sb.append("\n");

        // display cargo quantity required
        sb.append("\t \tCargo quantity required: " + cargoQuantity + " for each" + "\n \t");

        // display cargo required
        sb.append("\tCargo required for the mission: ");
        for (int i = 0; i < cargoRequired.size(); i++) {
            sb.append(cargoRequired.get(i));
            if (i == cargoRequired.size() -1) {
                sb.append(". ");
            } else {
                sb.append(", ");
            }
        }
        sb.append("\n");

        // display string for cargo list
        sb.append("\t \tCargo list:");
        for (int i = 0; i < cargoList.size(); i++) {
            sb.append( "\n \t \t \t" + (i + 1) + ": " + cargoList.get(i).displayCargo());
        }
        sb.append("\n \t");


        return sb.toString();
    }


}
