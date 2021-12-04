package voting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Result {
    
    Candidate candidate  ;
     private Scanner x ;
     int CandidteNumberOfVote =0 ; 
     int maxValue ;
    
    public Result(Candidate candidate) {
        this.candidate = candidate;
    }

    Result() {
        
    }
   public int getResultofCandidte(String currenCandidteNmae){
   
       String filpath = "VotingList.txt";
       String voterId = "";
       String candidateName = "" ; 
       CandidteNumberOfVote =0 ; 
        HashMap<String, String> hashMap = new HashMap();
         try {
            x = new Scanner(new File(filpath));
            x.useDelimiter("[,\n]"); 
             while (x.hasNext()) {  
                 voterId = x.next();
                 candidateName = x.next();
                 hashMap.put(voterId,candidateName);  
             }
             x.close();
                hashMap.keySet().stream().map((key) -> {
             return key;
         }).forEachOrdered((key) -> {
             if(hashMap.get(key).contains(currenCandidteNmae))
                 CandidteNumberOfVote++ ;         
         });
     
         }
         catch(FileNotFoundException e1){
                System.out.println("File not found");
         }
   
           
   return CandidteNumberOfVote;
   }
     public   HashMap<String,Integer> candidateList(){
        
        Scanner x ;
        String filpath  = "ListOfCandite.txt";
       String firstNameOfCandidate = null ;
       String lasstNameOfCandite = null ;
        String idOfUser = null ;
        String userNameOfUser ;
        String passwordOfUser = null ;
        String  phoneNumerOfUser = null ;                  
        String cityOfUser = null ;
        String  party_symbol,Electoral_program ; 
        HashMap<String,Integer> candidateVoted = new HashMap<>();

        try {
            x = new Scanner(new File(filpath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()) {

                firstNameOfCandidate = x.next();
                lasstNameOfCandite = x.next();
                idOfUser = x.next();   
                userNameOfUser = x.next();
                phoneNumerOfUser = x.next();
                cityOfUser = x.next();
                party_symbol = x.next();
                Electoral_program = x.next();
                candidateVoted.put(firstNameOfCandidate, 0);
                
            } 
    }
        catch(FileNotFoundException e1){}
         return candidateVoted;
    }
   public void ShowResult(){
   
        HashMap<String,Integer> candidateVoted =  candidateList();
       try {
                  for (String key : candidateVoted.keySet()) {
                    candidateVoted.replace(key, getResultofCandidte(key)) ;
                    
}
       } catch (Exception e) {
           
           
       }
         candidateVoted.forEach((key, value) -> System.out.println(key + " : " + value));
          maxValue = 0;

         for (Integer value : candidateVoted.values()) {
                    if(value > maxValue){
        maxValue = value;
    }
}
         candidateVoted.forEach((key, value) -> {
    if (value== maxValue) {
        System.out.println(key + " has most of the vote ");
    }
}); }     

   
   }