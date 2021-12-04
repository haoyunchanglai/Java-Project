package voting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class Registeration {

    private String firstName;
    private String lastName;
    private String id;
    private String userName;
    private String password;
    private String phoneNumber;
    private String city;
    private int ID;
    private Voter voter;
    private Scanner x;
    private boolean isLogin = false;

    public Registeration(String firstName, String lastName, String id, String userName, String password, String phoneNumber, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }

    public boolean Isvalidate() {

        if (!valFirsName(firstName)) {
            System.out.println("first name is unvalied");
            return false;
        }
        if (!valLastName(lastName)) {
            System.out.println("last name is unvalied");
        }
        if (!valPhone(phoneNumber)) {
            System.out.println("phone is unvalied");
            return false;
        }
        if (!valPassword(this.password)) {
            System.out.println("password is unvalied");
            return false;

        }
        if (!valUserName(userName)) {
            System.out.println("userName is unvalied");
            return false;
        }
        if (!valCity(city)) {

            System.out.println("city name is unvalied");
            return false;
        }
        return true;
    }

    /////////////////////////////////////////////////////////////////////
    // validate All Data
    public static boolean valPhone(String phoneNumber) {
        return  phoneNumber.length() == 11 && phoneNumber.matches("[0-9]+");

    }

    public boolean valLastName(String lastName) {

        return Pattern.matches("[a-zA-Z]+{3,6}", lastName);
    }

    public boolean valFirsName(String firstName) {

        return Pattern.matches("[a-zA-Z]+{3,6}", firstName);
    }

    public boolean valUserName(String userName) {
        return Pattern.matches("[a-zA-Z0-9]+-?_?", userName);
    }

    public boolean valPassword(String password) {

        if (password.length() >= 8) {
            return checkPassword(password);
        } else {
            System.out.println("Password is too small");
            return false;
        }
    }

    public boolean checkPassword(String password) {//大写小写有数字长度大于8
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasLower = false;
        char c;
        for (int i = 0; i < password.length(); i++) {
            c = password.charAt(i);
            if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (Character.isUpperCase(c)) {
                hasCapital = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            }
            if (hasCapital && hasLower && hasNumber) {
                return true;
            }
        }
        return false;

    }
    public boolean valID(String id) {//14位只能有数字
        if (!Pattern.matches("[0-9]+", id)) {
            return false;
        }
        return id.length() == 14;
    }

    public boolean valCity(String city) {

        return Pattern.matches("[a-zA-Z]+", city);
    }
    //////////////////////////////////////////////////

    public void SignUp(String firstName, String lastName, String id, String userName,
            String password, String phoneNumber, String city, String filePath, boolean Isvalidate) {
        if (!Isvalidate) {
        } else {
            try {
                FileWriter fw = new FileWriter(filePath, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fw);
                try (PrintWriter pw = new PrintWriter(bufferedWriter)) {
                    pw.println(firstName + "," + lastName + "," + id + "," + userName + "," + password + "," + phoneNumber + "," + city);
                    pw.flush();

                }

            } catch (IOException e) {
                System.out.println("File not Found And"
                        + "Data is unsaved");
            }
        }
    }

    public void login(String SearchTerm, String password, String filpath) {
        boolean found = false;
        String Fristname = null;
        String LastName = null;
        String idOfVoter = null;
        String userNameOfVoter = null;
        String passwordOfVoter = null;
        String phoneNumerOfVoter = null;
        String cityOfVoter = null;
        int TicketAvailable = 0;
        try {
            x = new Scanner(new File(filpath));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {

                Fristname = x.next();
                LastName = x.next();
                idOfVoter = x.next();
                userNameOfVoter = x.next();
                passwordOfVoter = x.next();
                phoneNumerOfVoter = x.next();
                cityOfVoter = x.next();
                TicketAvailable = x.nextInt();
                
                if (idOfVoter.equals(SearchTerm) || userNameOfVoter.equals(SearchTerm)) {//只要我找到名字或者是ID即认为我已经找到
                    found = true;
                }
            }
            if (found) {
                if (!(passwordOfVoter.equals(password))) {
                    System.out.println("Incorrect password");
                } else {
                    this.isLogin = true ;
                     
                    Voter CurrentVoter = new Voter(Fristname, LastName, idOfVoter, userNameOfVoter, password, phoneNumerOfVoter, cityOfVoter,TicketAvailable);
                    setVoter(CurrentVoter);
                    

                }
            }
            else {
            
                    System.out.println("no such elemnt in");
            }

        } catch (FileNotFoundException e) {
        }

    }

    public Registeration() {
    }

    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    public boolean isRegiestedBefore(String ID) {
        String filepatht = "Voter.txt";
        boolean found = false;
        String Fristname = null;
        String LastName = null;
        String idOfVoter = null;
        String userNameOfVoter = null;
        String passwordOfVoter = null;
        String phoneNumerOfVoter = null;
        String cityOfVoter = null;
        try {
            x = new Scanner(new File(filepatht));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                Fristname = x.next();
                LastName = x.next();
                idOfVoter = x.next();
                userNameOfVoter = x.next();
                passwordOfVoter = x.next();
                phoneNumerOfVoter = x.next();
                cityOfVoter = x.next();
                if (idOfVoter.equals(ID)) {
                    found = true;
                }
            }
        } catch (IOException e1) {
            System.out.println("file not found");

        }
        return found;
    }

    public boolean isIsLogin() {
        return isLogin;
    }

}
