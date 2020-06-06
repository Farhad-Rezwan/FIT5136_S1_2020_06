package main.java.missontomars.control;

import main.java.missontomars.model.Feature2.GetShuttle;
import main.java.missontomars.model.Shuttle;
import main.java.missontomars.model.User;

import java.util.ArrayList;

public class LoginTest {
    public static void main(String... args) {
        Login login = new Login();
        ArrayList<String[]> allUser = login.readUser();
        User user = login.login(allUser);
    }
}
