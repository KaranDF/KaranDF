
import java.util.*;
import java.math.BigDecimal;
import java.util.Comparator;



class Account {


    
    public String Accname;
    public Long phone;
    public BigDecimal revenue;
    public String address;

    public Account(String Accname, Long phone, BigDecimal revenue, String address) {
        this.Accname = Accname;
        this.phone = phone;
        this.revenue = revenue;
        this.address = address;
    }

    public String getName() {
        return Accname;
    }

    public String toString() {
        return Accname;
    }
    public BigDecimal getrevenue() {
        return revenue;
    }
}
class Contact {

    public String firstName;
    public String lastName;
    public Number contactNo;
    public List<String> AccountsRelated;

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName() {
        return firstName;
    }
}

class Opportunity {
    public enum Stages {
        NeedsAnalysis, ClosedWon, Qualification, ClosedLost, Negotiation, Prospecting

    }
    
    public String oppName;
    public List<String> AccountRelated;
    public BigDecimal amount;
    public Date CloseDate;
    public Enum Stages;

    public Opportunity(String oppName, BigDecimal amount, Enum Stages) {

        this.oppName = oppName;
        this.amount = amount;
        this.Stages = Stages;
    }
    
    public Number getAmount() {
        return amount;
    }

    public String GetoppName() {
        return oppName;
    }

    public Enum getStages() {
        return this.Stages;
    }

    // public void setStages(Enum Stages) {
    //     this.Stages = Stages;
    // } Variable Setter
}

public class datamodeling {
    private static final Account[] Acc = null;

    public static void main(String[] args) {

        List<Account> Acc = new ArrayList<Account>();
        System.out.println("\n Accounts \n");
        Account a1 = new Account("Google", (long) 834454583, (new BigDecimal("1000")), "Delhi");
        Account a2 = new Account("DemandFarm", (long) 865555583, (new BigDecimal("20000")), "Pune");
        Account a3 = new Account("Persistent", (long) 823336683, (new BigDecimal("50000")), "Nagpur");
        Account a4 = new Account("Hundai", (long) 823336683, (new BigDecimal("7000")), "Gujrat");
        Account a5 = new Account("Honda City", (long) 823336683, (new BigDecimal("90000")), "UP");

        //Adding Accounts
        Acc.add(a1);
        Acc.add(a2);
        Acc.add(a3);
        Acc.add(a4);
        Acc.add(a5);
        
        
        //List of all accounts Where revenue > 10000
        System.out.println("List of all accounts Where revenue > 10000 \n" );
        for (Account a : Acc) 
        {
            
            if (a.getrevenue().intValueExact() > 10000) {
                System.out.println(a);
            }
        }

        //Sorting account by revenue
        System.out.println("\n Sorting account by revenue \n");
        Collections.sort(Acc, new Comparator<Account>() {

            public int compare(Account a1, Account a2) {
        
               BigDecimal c1 = a1.getrevenue();
               BigDecimal c2 = a2.getrevenue();
        
            //    /For ascending order/
               return c1.compareTo(c2);
               
           }});

           for (Account a : Acc) {
               System.out.println(a.Accname+" "+ a.revenue);
           }

         
       
        // System.out.println("Sorting account by revenue:");  
        // for(Account a : Acc){
        //     System.out.println(a);
        // }
       

        
        List<Contact> Con = new ArrayList<Contact>();
        System.out.println("\n Contacts \n");
        Contact con1 = new Contact("Nikunj", "Sharma");
        Contact con2 = new Contact("Ashish", "Agrawal");

        Con.add(con1);
        Con.add(con2);

        for (Contact con : Con) {
            System.out.println(con.firstName);
        }

        List<Opportunity> Opp = new ArrayList<Opportunity>();
        enum Stages{NeedsAnalysis, ClosedWon, Qualification, ClosedLost, Prospecting}
        System.out.println("\n Opportunities \n");
        Opportunity op1 = new Opportunity("Analysing an Application", (new BigDecimal("20000")), Stages.Prospecting);
        Opportunity op2 = new Opportunity("Configration of router", (new BigDecimal("9000")), Stages.ClosedWon);
        Opportunity op3 = new Opportunity("Creating an Application", (new BigDecimal("1000")), Stages.ClosedLost);
        Opportunity op4 = new Opportunity("Configration of router", (new BigDecimal("50000")), Stages.Prospecting);
        Opportunity op5 = new Opportunity("Configration of router", (new BigDecimal("100000")), Stages.NeedsAnalysis);

        Opp.add(op1);
        Opp.add(op2);
        Opp.add(op3);
        Opp.add(op4);
        Opp.add(op5);
        // for(Opportunity op: Opp){
        //     System.out.println(op.oppName+ " "+ op.revenue + " " + op.getStages());
        // }
        System.out.println("Printing the opportunity where stages is equal to Prospecting : ");
        for (Opportunity op : Opp) {
            if (op.getStages() == Stages.Prospecting)
          
                System.out.println(op.oppName + " " + "Stage: " + op.getStages());
        }
    }
}

//Contacts hirarchy