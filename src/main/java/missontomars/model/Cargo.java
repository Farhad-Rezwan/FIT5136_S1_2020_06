package main.java.missontomars.model;

public class Cargo {
    private int cargo_Id;
    private String cargo;
    private int quantityAvailable;

    public Cargo(int cargo_Id, String cargo, int quantityAvailable) {
        this.cargo_Id = cargo_Id;
        this.cargo = cargo;
        this.quantityAvailable = quantityAvailable;
    }

    public Cargo() {
    }

    public int getCargo_Id() {
        return cargo_Id;
    }

    public void setCargo_Id(int cargo_Id) {
        this.cargo_Id = cargo_Id;
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
}
