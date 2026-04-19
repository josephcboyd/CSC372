public class CheckingAccount extends BankAccount {
    private double interestRate;
    private static final double OVERDRAFT_FEE = 30.00;

    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(firstName, lastName, accountID); // call BankAccount constructor
        this.interestRate = interestRate;
    }

    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
    public double getInterestRate() { return interestRate; }

    // allows withdrawl when overdraft and changes fee
    public void processWithdrawal(double amount) {
        withdrawal(amount); // call parent method to subtract amount

        if (getBalance() < 0) {
            withdrawal(OVERDRAFT_FEE); // charge the overdraft fee
            System.out.printf("Overdraft fee of $%.2f has been assessed.%n", OVERDRAFT_FEE);
            System.out.printf("Current balance (with fee): $%.2f%n", getBalance());
        }
    }

    // displays all superclass fields plus interest rate
    public void displayAccount() {
        accountSummary(); // call parent method
        System.out.printf("Interest Rate: %.2f%%%n", interestRate * 100);
        System.out.println("-------------------------");
    }
}