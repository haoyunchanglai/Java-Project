package voting;

import java.util.ArrayList;
import java.util.Scanner;

public class VoterInterFace {

    private Scanner sc = new Scanner(System.in);
    int LoobCondation = 1;
    String fristName, lastName, id, userName, password, phoneNumber, city;
    voting.Voter currentVoter;
    private voting.VotingForm v;

    public void VoterSystmetUI() {//选择界面

        int chooseOfVoter = 0;
        int x;
        boolean invalidin = true;
        while (invalidin) {
            System.out.println("-----------------------------------");

            System.out.println("1-create new account \n2-login\n3-Exit  \nChoose:");

            chooseOfVoter = sc.nextInt();

            System.out.println("-----------------------------------");

            switch (chooseOfVoter) {
                case 3:
                   
                    break;
                case 1:
                    System.out.println("Enter FristName : ");
                    fristName = sc.next();
                    System.out.println("Enter LastName : ");
                    lastName = sc.next();
                    System.out.println("Enter ID :");
                    id = sc.next();
                    System.out.println("Enter Password : ");
                    password = sc.next();
                    System.out.println("Enter UserName : ");
                    userName = sc.next();
                    System.out.println("Enter PhoneNumber :");
                    phoneNumber = sc.next();
                    System.out.println("Enter City : ");
                    city = sc.next();
                    voting.Registeration re = new voting.Registeration(fristName, lastName, id, userName, password, phoneNumber, city);
                    boolean val = re.Isvalidate();
                    if (!re.isRegiestedBefore(id)) {
                        re.SignUp(fristName, lastName, id, userName, password, phoneNumber, city, fristName, val);
                    } else {
                        System.out.println("you've already registered");
                    }
                    boolean success = re.Isvalidate();

                    if (success) {

                        re.SignUp(fristName, lastName, id, userName, password, phoneNumber, city, "Voter.txt", success);
                         voting.Voter v = re.getVoter();
                        System.out.println("done");
                    }
                    invalidin = false;
                    break;

                case 2:
                    String filepath = "Voter.txt";//记得在结尾加上TicketAvailable；
                    boolean isLoginsuccess;

                    System.out.println("Enter your UserName or ID :");
                    userName = sc.next();
                    System.out.println("Enter your Password :");
                    password = sc.next();
                    voting.Registeration registeration = new voting.Registeration();
                    registeration.login(userName, password, filepath);
                    isLoginsuccess = registeration.isIsLogin();
                    if (isLoginsuccess) {
                        currentVoter = registeration.getVoter();
                        System.out.println("Welcome To Voting System " + currentVoter.getFirstName());
                        System.out.println("----------------------------------------");
                        VoterOtion();
                    }
                    invalidin = false;
                    break;

                default:
                    System.out.println("-----------------------");
                    System.out.println("Try Again! ");
                    System.out.println("-----------------------");
            }
            invalidin = false;
        }

        System.out.println("Thank You for using our Voting System \nGood Luck!");
        //System.exit(LoobCondation);

    }

    public void VoterOtion() {
        System.out.println("1-ShowCandidateInfo\n2-Add vote\n3-Delete Vote");
        System.out.println("----------------------------------------");
        int LoobCondation2 = 1;
        int option;
        boolean notvalid = true;
        while (notvalid) {
            option = sc.nextInt();
            v = new voting.VotingForm();
            switch (option) {
                case 1:
                    v.showCandidatesInfo();

                    break;

                case 2:
                    int getNumberOfcandidate;
                    String candidteName = null;
                    ArrayList<String> ListOfCandidate = v.candidateList();
                    for (int i = 0; i < ListOfCandidate.size(); i++) {
                        System.out.println(i + 1 + "-" + ListOfCandidate.get(i));
                    }
                    System.out.println("Enter Number Of Candidate You Want to Vote");
                    getNumberOfcandidate = sc.nextInt();
                    try {
                        candidteName = v.getCandidateName(getNumberOfcandidate);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("not such candidte in this number");
                    }
                    currentVoter.submitvote(candidteName);

                    break;
                case 3:
                    //
                    System.out.println("done");
                    break;
                default:
                    System.out.println("-----------------------");
                    System.out.println("Try Again! ");
                    System.out.println("-----------------------");
            }
            System.out.println("1-Back to main list" + "\n2-Back to option menu");
            System.out.println("-------------------------");
            Scanner in = new Scanner(System.in);
            int chose = in.nextInt();
            if (chose == 1) {
                notvalid = true;
                VoterOtion();

            } else {

                VoterSystmetUI();
            }

        }

    }
}
