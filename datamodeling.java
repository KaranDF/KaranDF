
import java.util.*;
import java.util.Map.Entry;
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

    Account(String Accname) {
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

    public Integer GetId() {
        return id;
    }

}

class Contact {

    static int ContactCount = 0;
    int contactID;
    List<Contact> ContactList = new ArrayList<Contact>();
    public String firstName;
    public String lastName;
    public Number contactNo;
    public String RelatedAccountName;

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        contactID = (++ContactCount);
        ContactList.add(this);
    }

    public String getName() {
        return firstName;
    }

    // public void reportsTo(Contact con) {
    // this.reportsTo = con;
    // }

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
    // this.Stages = Stages;
    // } Variable Setter
}

public class datamodeling {

    public static void main(String[] args) {
        // Accounts

        List<Account> Acc = new ArrayList<Account>();
        System.out.println("\n\n--------Accounts--------");
        Account a1 = new Account("Google", (long) 834454583, (new BigDecimal("1000")));
        Account a2 = new Account("DemandFarm", (long) 865555583, (new BigDecimal("20000")));
        Account a3 = new Account("Persistent", (long) 823336683, (new BigDecimal("50000")));
        Account a4 = new Account("Hundai", (long) 823336683, (new BigDecimal("7000")));
        Account a5 = new Account("Honda City", (long) 823336683, (new BigDecimal("90000")));

        // Adding Accounts
        Acc.add(a1);
        Acc.add(a2);
        Acc.add(a3);
        Acc.add(a4);
        Acc.add(a5);

        for (Account a : Acc) {
            System.out.println(a.Accname + " " + a.revenue + " " + a.phone);
        }
        // List of all accounts Where revenue > 10000
        System.out.println("\n List of all accounts Where revenue > 10000 \n");
        for (Account a : Acc) {

            if (a.getrevenue().intValueExact() > 10000) {
                System.out.println(a);
            }
        }

        // Sorting account by revenue
        System.out.println("\n Sorting account by revenue \n");
        Collections.sort(Acc, new Comparator<Account>() {

            public int compare(Account a1, Account a2) {

                BigDecimal c1 = a1.getrevenue();
                BigDecimal c2 = a2.getrevenue();

                // /For ascending order/
                return c1.compareTo(c2);

            }
        });
        for (Account a : Acc) {
            System.out.println(a.Accname + " " + a.revenue);
        }

        // Contacts

        List<Contact> ContactList = new ArrayList<Contact>();

        System.out.println("\n\n--------Contacts--------");
        Contact con1 = new Contact("Nikunj", "Sharma");
        Contact con2 = new Contact("Ashish", "Agrawal");
        Contact con3 = new Contact("MS", "Dhoni");
        Contact con4 = new Contact("Virat", "Agrawal");
        Contact con5 = new Contact("Raina", "shetty");

        ContactList.add(con1);
        ContactList.add(con2);
        ContactList.add(con3);
        ContactList.add(con4);
        ContactList.add(con5);

        for (Contact con : ContactList) {
            System.out.println(con.firstName + " " + con.lastName);
        }
        System.out.println("\n\n--------Contacts Hirerachy--------");
        HashMap<Contact, Contact> map = new HashMap<Contact, Contact>();

        map.put(con1, null);
        map.put(con2, con1);
        map.put(con3, con1);
        map.put(con4, con3);
        map.put(con5, con3);

        for (Map.Entry<Contact, Contact> e : map.entrySet()) {
            if (e.getValue() == null) {
                System.out.println("Can't Reach for Contact " + e.getKey().contactID);
            } else {
                System.out.println(e.getKey().contactID + " --> " + e.getValue().contactID);

            }
        }

        System.out.println("\n\n--------------Related Contacts-----------------");
        Map<Account, Contact> accountToConMap = new HashMap<Account, Contact>();
        accountToConMap.put(a1, con1);
        accountToConMap.put(a2, con1);
        accountToConMap.put(a3, con3);
        accountToConMap.put(a4, con2);
        accountToConMap.put(a5, con5);
        accountToConMap.put(a4, con5);

        for (Entry<Account, Contact> e : accountToConMap.entrySet()) {
            System.out.println(e.getKey().Accname + " " + "Contact related to this account is " + " "
                    + e.getValue().firstName + " " + e.getValue().lastName);
        }

        // Opportunity
        List<Opportunity> Opp = new ArrayList<Opportunity>();
        enum Stages {
            NeedsAnalysis, ClosedWon, Qualification, ClosedLost, Prospecting
        }
        System.out.println("\n\n-------Opportunities--------");
        Opportunity op1 = new Opportunity(+"Analysing an Application", (new BigDecimal("20000")),Stages.Prospecting);
        Opportunity op2 = new Opportunity("Configration of router", (new BigDecimal("9000")), Stages.ClosedWon);
        Opportunity op3 = new Opportunity("Creating an Application", (new BigDecimal("1000")), Stages.ClosedLost);
        Opportunity op4 = new Opportunity("Configration of router", (new BigDecimal("50000")), Stages.Prospecting);
        Opportunity op5 = new Opportunity("Configration of router", (new BigDecimal("100000")), Stages.NeedsAnalysis);

        Opp.add(op1);
        Opp.add(op2);
        Opp.add(op3);
        Opp.add(op4);
        Opp.add(op5);

        for (Opportunity op : Opp) {
            System.out.println(op.oppName + " " + op.amount + " " + op.getStages());
        }

        System.out.println("\n Printing the opportunity where stages is equal to Prospecting :- \n ");
        for (Opportunity op : Opp) {
            if (op.getStages() == Stages.Prospecting)

                System.out.println(op.oppName + " " + "Stage: " + op.getStages());
        }
    }
    

}