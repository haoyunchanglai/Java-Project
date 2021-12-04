package voting;

import java.io.IOException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
   
        int chooseUser = 0;
       System.out.println("______________________________________");
        System.out.println("| Choose from following options:-    |");
        System.out.println("| -------------------------------    |");
        System.out.println("| 1-Admin \t\t\t     |");
        System.out.println("| 2-Voter \t\t\t     |");
        System.out.println("_______________________________________");
        System.out.print("=> Choose one: ");

        if (sc.hasNextInt()) {
            chooseUser = sc.nextInt();
        } else {
            System.err.println("please enter number");
        }

        switch (chooseUser) {
            // if he is admin   
            case 1:

                AdminInterface adminInterface = new AdminInterface();
                adminInterface.adminSystemUI();
                break;
            // if he is Voter
            case 2:
                VoterInterFace voterInterFace = new VoterInterFace();
                voterInterFace.VoterSystmetUI();

                break;

        }
    }

    }


