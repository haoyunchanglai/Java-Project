package voting;

import java.util.Scanner;

public class AdminInterface {
    
    
    private Scanner sc = new Scanner(System.in);
    String AdminUserName,
           AdminPassword;
    private  Admin admin ;
            
    public boolean AdminLggIn(){
    
    
                System.out.println("Enter your UserName :");
                AdminUserName = sc.next();
                System.out.println("Enter your Password :");
                AdminPassword = sc.next();
                admin = new Admin();
                return admin.AdminIsLogIn(AdminUserName, AdminPassword);
                
    
    } 
    public void adminSystemUI(){
    int chooseOfCandidte = 0; 
      String fristName, lastName, id, userName, password, phoneNumber, city, party_symbol, Electoral_program;
       
         Result result = new Result();
               
                int status = 1;
                if(AdminLggIn()){
                    admin = new Admin();
                   do {
                        System.out.println("-------------------------------------");

                        System.out.println(

                                 "2-show Candidtes Name "
                                + "\n3-Add Candite"
                                + "\n4-Show Result"
                        );
                        System.out.println("-------------------------------------");
                        System.out.println("choose the number of  method you want");
                        if (sc.hasNextInt()) {
                            chooseOfCandidte = sc.nextInt();
                        }

                        switch (chooseOfCandidte) {

                            case 2:
                                Admin.showCanditeName();
                                break;

                            case 3:
                                System.out.println("Enter FristName : ");
                                fristName = sc.next();
                                System.out.println("Enter LastName : ");
                                lastName = sc.next();
                                System.out.println("Enter ID :");
                                id = sc.next();
                                System.out.println("Enter UserName : ");
                                userName = sc.next();
                                System.out.println("Enter PhoneNumber :");
                                phoneNumber = sc.next();
                                System.out.println("Enter City : ");
                                city = sc.next();
                                System.out.println("Enter Party Symbol : ");
                                party_symbol = sc.next();
                                System.out.println("Enter Electoral Program : ");
                                Electoral_program = sc.next();
                                admin.addCandidte(fristName, lastName, id, userName, phoneNumber, city, party_symbol, Electoral_program);
                                break;
                            case 4:
                               
                                Admin  a= new Admin(result);
                                a.showResult();
                                
                                break;

                            default:
                                System.out.println("-----------------------");
                                System.out.println("Try Again! ");
                                System.out.println("-----------------------");
                        }

                        System.out.println("1-Back to main list"
                                + "\n2-Exit");
                        System.out.println("-------------------------");

                        status = sc.nextInt();
                    } while (status == 1);
                    System.out.println("Thank You for using our Voting System \nGood Luck!");
                    System.exit(status);
    
                
                
                
                }
               
                
    
     
     
    }
    
    
}
