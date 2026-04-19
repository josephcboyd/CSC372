public class TestBankAccount {
    public static void main(String[] args) {

        System.out.println("=== BankAccount Test ===");
        BankAccount basic = new BankAccount("Jane", "Smith", 1001);
        basic.deposit(500.00);
        basic.withdrawal(150.00);
        basic.accountSummary();

        System.out.println("\n=== CheckingAccount Test ===");
        CheckingAccount checking = new CheckingAccount("John", "Doe", 2001, 0.03);
        checking.deposit(200.00);

        System.out.println("\n-- Normal withdrawal --");
        checking.processWithdrawal(50.00);
        checking.displayAccount();

        System.out.println("\n-- Overdraft withdrawal --");
        checking.processWithdrawal(300.00); // will overdraft
        checking.displayAccount();
    }
}