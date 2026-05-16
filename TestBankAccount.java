public class TestBankAccount {
    public static void main(String[] args) {

        System.out.println("BankAccount Test");
        BankAccount basic = new BankAccount("Jane", "Smith", 1001);
        basic.atm(500.00);
        basic.atm(-150.00);
        basic.accountSummary();


        System.out.println("\nCheckingAccount Test");
        CheckingAccount checking = new CheckingAccount("John", "Doe", 2001, 0.03);
        checking.atm(200.00);
        basic.accountSummary();


        System.out.println("\nNormal withdrawal");
        checking.atm(-50.00);
        basic.accountSummary();

        System.out.println("\nOverdraft withdrawal");
        checking.atm(-300.00); // will overdraft
        basic.accountSummary();
    }
}