public class BankAccount {
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;
    private static final double OVERDRAFT_FEE = -30.00;

    //constructor
    public BankAccount(String firstName, String lastName, int accountID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
        this.balance = 0.0;
    }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName)   { this.lastName = lastName; }
    public void setAccountID(int accountID)    { this.accountID = accountID; }

    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public int getAccountID()    { return accountID; }
    public double getBalance()   { return balance; }

    // adds the given amount to the balance
    public void atm(double amount) { //updated to use a single method for deposits and withdrawls and logic for what message to display
        balance += amount;
        if (amount > 0) {
            System.out.printf("Deposited: $%.2f%n", amount);
        }
        else 
            {
            System.out.printf("Withdrew: $%.2f%n", amount);
        }
        if (getBalance() < 0) {
            balance += OVERDRAFT_FEE; // charge the overdraft fee
            System.out.printf("Overdraft fee of $%.2f has been assessed.%n", OVERDRAFT_FEE);
            System.out.printf("Current balance (with fee): $%.2f%n", getBalance());
        }
    }

    public void accountSummary() {
        System.out.printf("Customer: %s %s%n", firstName, lastName);
        System.out.println("-------------------------");
        System.out.printf("%-10s | %-12s%n", "Account #", "Balance");
        System.out.println("-------------------------");
        System.out.printf("%-10d | $%,-11.2f%n", accountID, balance);
        System.out.println("-------------------------");
    }
}