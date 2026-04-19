public class BankAccount {
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

  

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

    // Adds the given amount to the balance
    public void deposit(double amount) {
        balance += amount;
        System.out.printf("Deposited: $%.2f%n", amount);
    }

    // Subtracts the given amount from the balance
    public void withdrawal(double amount) {
        balance -= amount;
        System.out.printf("Withdrew: $%.2f%n", amount);
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