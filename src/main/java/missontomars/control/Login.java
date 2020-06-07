package main.java.missontomars.control;

import main.java.missontomars.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    /**
     * Method which read user information from file
     * @return A user information string list
     */
    public ArrayList<String[]> readUser(){
        ArrayList<String[]> allUser = new ArrayList<>();
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader("user.csv"));
            reader1.readLine();
            String line;
            while((line=reader1.readLine())!=null){
                String[] item = line.split(",");
                allUser.add(item);
            }
            reader1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allUser;
    }

    /**
     * Method for log in
     * @param allUser A user information string list
     * @return The login user
     */
    public User login(ArrayList<String[]> allUser){
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Please input username");
        String usernameInput = sc1.nextLine();
        System.out.println("Please input password");
        String passwordInput = sc1.nextLine();
//        sc1.close();
        User user = null;
        Boolean success = false;
        for(int i=0; i<allUser.size(); i++){
            if(allUser.get(i)[1].equals(usernameInput) && allUser.get(i)[2].equals(passwordInput)){
                user = new User(Integer.parseInt(allUser.get(i)[0]),allUser.get(i)[0],allUser.get(i)[0],allUser.get(i)[0]);
                System.out.println("Welcome "+allUser.get(i)[1]);
                success = true;
            }
        }
        if(!success){
            System.out.println("Username or password is wrong");
        }
        return user;
    }
}
