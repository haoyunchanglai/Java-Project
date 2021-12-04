package voting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vote {

    //private Date timeOfVoting;
    public String VoterID;
    public String CandidateName;
    private Scanner x;
   

    public void addVote(String VoterID, String CandidateName) {//投票
        HashMap<String, String> VoteList = new HashMap<>();
        HashMap<String, String> storedVotList = (HashMap<String, String>) ListOfVote();
        if (!(hasVote(VoterID))) {
            VoteList.put(VoterID, CandidateName);
        } else {
            System.out.println("you already voted");
        }//这边是每个选民的投票ID+候选人名字

    }
    public String serch(String id){//输入一个投票者的ID看他投了谁
            String filePath = "VotingList.txt";
             String voterId = "";
             String candidateName = null;
             try {
            x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                voterId = x.next();
                candidateName = x.next();
                if(voterId.equals(id)){
                return candidateName;
                }       
            }
            x.close();
        } catch (FileNotFoundException e1) {
            System.out.println("File not found");
        }
    return  candidateName;
    }

    public void saveVote(String VoterID, String CandidateName) {//将vote结果写入文件
        String filePath = "VotingList.txt";
        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            try (PrintWriter pw = new PrintWriter(bufferedWriter)) {
                pw.println(VoterID + "," + CandidateName);
                pw.flush();
            }
        } catch (IndexOutOfBoundsException e1) {
            System.out.println("Fie not found");
        } catch (IOException ex) {
            Logger.getLogger(Vote.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean hasVote(String VoterId) {//看某个ID是否投过票
           HashMap<String,String> List = (HashMap<String,String>) ListOfVote();
        return List.containsKey(VoterId);
    }

    public Map<String, String> ListOfVote() {//读档,如果有在文件中就把它放进哈希表里
        String filpath = "VotingList.txt";
        String voterId = "";
        String candidateName = "";
        HashMap<String, String> hashMap = new HashMap();
        try {
            x = new Scanner(new File(filpath));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                voterId = x.next();
                candidateName = x.next();
                hashMap.put(voterId, candidateName);
            }
            x.close();
        } catch (FileNotFoundException e1) {
            System.out.println("File not found");
        }
        return hashMap;
    }
}
