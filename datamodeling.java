
import java.util.*;



import java.math.BigDecimal;

class Account {

    List<Account> Acc = new ArrayList<Account>();
    int AccountId;
    static int count = 0;
    public String Accname;
    public Long phone;
    public BigDecimal revenue;
    public List<Contact> relatedContacts;
    public Integer id;
    public Account(String Accname, Long phone, BigDecimal revenue) {
        this.Accname = Accname;
        this.phone = phone;
        this.revenue = revenue;
    }
    Account(String Accname){
        this.Accname = Accname;
        AccountId = (++count);
        Acc.add(this);
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
    public Integer GetId(){
        return id;
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
        //Accounts
        List<Account> Acc = new ArrayList<Account>();
        System.out.println("\n Accounts \n");
        Account a1 = new Account("Google", (long) 834454583, (new BigDecimal("1000")));
        Account a2 = new Account("DemandFarm", (long) 865555583, (new BigDecimal("20000")));
        Account a3 = new Account("Persistent", (long) 823336683, (new BigDecimal("50000")));
        Account a4 = new Account("Hundai", (long) 823336683, (new BigDecimal("7000")) );
        Account a5 = new Account("Honda City", (long) 823336683, (new BigDecimal("90000")) );

        //Adding Accounts
        Acc.add(a1);
        Acc.add(a2);
        Acc.add(a3);
        Acc.add(a4);
        Acc.add(a5);
        
        for(Account a: Acc){
            System.out.println(a.Accname+" "+ a.revenue+ " "+ a.phone);
        }
        //List of all accounts Where revenue > 10000
        System.out.println("\n List of all accounts Where revenue > 10000 \n" );
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

           
        
         //Contacts 
 
        List<Contact> Con = new ArrayList<Contact>();
      Contact reportsTo;
        System.out.println("\n Contacts \n");
        Contact con1 = new Contact("Nikunj", "Sharma");
        Contact con2 = new Contact("Ashish", "Agrawal");
        Contact con3 = new Contact("MS", "Dhoni");
        Contact con4 = new Contact("Virat", "Agrawal");
        Contact con5 = new Contact("Raina", "shetty");
          
        Con.add(con1);
        Con.add(con2);
        Con.add(con3);
        Con.add(con4);
        Con.add(con5);

        for (Contact con : Con) {
            System.out.println(con.firstName + " "+ con.lastName);
        }
        
        Map<Integer, List<Contact>> AccountRtoconMap = new HashMap<>();

        for(Account a : Acc){
            AccountRtoconMap.put(a.AccountId,a.relatedContacts);
        }
        // System.out.println("Account ID:List<Contacts> ");
        // System.out.println(AccountRtoconMap);
        // con3.reportsTo(con1);
        // con4.reportsTo(con2);
        // con5.reportsTo(con3);
        // con2.reportsTo(con3);
        // System.out.print(con1.reportsTo(con3));


        //Opportunity
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

        for(Opportunity op: Opp){
            System.out.println(op.oppName+ " "+ op.amount + " " + op.getStages());
        }

        System.out.println("\n Printing the opportunity where stages is equal to Prospecting :- \n ");
        for (Opportunity op : Opp) {
            if (op.getStages() == Stages.Prospecting)
          
                System.out.println(op.oppName + " " + "Stage: " + op.getStages());
        }
    }
    
}