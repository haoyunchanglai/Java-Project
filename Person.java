
package voting;

public abstract class   Person {

    protected String firstName;//
    protected  String  lastName;//
    protected String id;
    protected String userName;
    protected String phoneNumber;
    protected String city;
   
    

  public Person(String firstName ,String lastName, String id, String userName, String phoneNumber, String city) {
        this.firstName = firstName ;
        this.lastName = lastName;
        this.id = id;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }
    public Person() {
    }

    public Person(String firstName, String lastName, String id, String phoneNumber, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }

   
  
   
    
    
    
}
