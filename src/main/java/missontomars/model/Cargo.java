package main.java.missontomars.model;

public class Cargo {
    private int cargoId;
    private String cargo;
    private int quantityAvailable;

    public Cargo(int cargo_Id, String cargo, int quantityAvailable) {
        this.cargoId = cargo_Id;
        this.cargo = cargo;
        this.quantityAvailable = quantityAvailable;
    }

    public Cargo() {
    }

    public int getCargo_Id() {
        return cargoId;
    }

    public void setCargo_Id(int cargoId) {
        this.cargoId = cargoId;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    /**
     * Method for displaying the cargo information
     * @return A display string
     */
    public String displayCargo () {
        StringBuilder sb = new StringBuilder();
        sb.append("Cargo id: " + cargoId + ", cargo : " + cargo + ", cargo quantity available: " + quantityAvailable);

        return sb.toString();
    }
}
