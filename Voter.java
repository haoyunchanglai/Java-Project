package voting;

public final class Voter extends Person {//改动:增加可投票数的变量

    private String password;
    private int TicketAvailable;//

    private final Vote vote = new Vote();

    public Voter(String FirstName, String LastName, String ID, String username, String password, String phoneNumber, String city, int TicketAvailable) {

        super(FirstName, LastName, ID, phoneNumber, city);
        this.password = password;
        this.TicketAvailable = TicketAvailable;
    }

    public boolean ISVoted() {
        return vote.hasVote(this.id);
    }

    public void submitvote(String CandidateName) {
        if (!vote.hasVote(id)) {//如果没投过票就把id和候选人名字加到VoteList哈希表中也就是VoltingList.txt
            vote.addVote(this.id, CandidateName);
            vote.saveVote(getId(), CandidateName);
            System.out.println("done");

        }
        else{
        
            System.out.println("already vote");
        }

    }

    public String getCadidateName() {//看id投了谁

        return vote.serch(id);
    }

    public String getId() {
        return this.id;
    }

    public Vote getVote() {
        return vote;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }

}
