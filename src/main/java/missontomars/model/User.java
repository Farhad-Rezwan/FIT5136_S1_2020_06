package main.java.missontomars.model;

public class User {
    private int id;
    private String userName;
    private String password;
    private String accountType;

    public User(int id, String userName, String password, String accountType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.accountType = accountType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
