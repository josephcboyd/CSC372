public class CheckingAccount extends BankAccount {
    private double interestRate;

    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(firstName, lastName, accountID); // call BankAccount constructor
        this.interestRate = interestRate;
    }

    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
    public double getInterestRate() { return interestRate; }


    // displays all superclass fields plus interest rate
    public void displayAccount() {
        accountSummary(); // call parent method
        System.out.printf("Interest Rate: %.2f%%%n", interestRate * 100);
        System.out.println("-------------------------");
    }
}