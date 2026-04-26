import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BankAccountGui extends JFrame implements ActionListener {
   private JButton withdrawlButton;        //button for withdraw
   private JLabel balanceLabel;              // Label for balance
   private JLabel withdrawlLabel;            // Label for withdraw firld
   private JLabel accountIDLabel;          // label for account number
   private JFormattedTextField balanceField;        // Displays current balance
   private JFormattedTextField withdrawField;      // Displays withdraw entry field
   private JTextField accountIDField;         //field for account id

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
BankAccountGui(String accountID, double startingBalance) {      // Used to specify GUI component layout
      GridBagConstraints layoutConst = null;

      // Set frame's title
      setTitle("GUI BANK INC.");

      // Create labels
      accountIDLabel = new JLabel("Account #:");
      balanceLabel = new JLabel("Balance amount");
      withdrawlLabel = new JLabel("Enter the amnount to withdraw:");

      // Create button and add action listener
      withdrawlButton = new JButton("Withdraw");
      withdrawlButton.addActionListener(this);

      // Create withdrawl amount field
      balanceField = new JFormattedTextField(NumberFormat.getCurrencyInstance());
      balanceField.setValue(startingBalance);
      balanceField.setEditable(false);
      balanceField.setColumns(15);

      // Create account id  field
      accountIDField = new JTextField(accountID);
      accountIDField.setEditable(false);

      // Create and setup an input field for numbers (not text)
      withdrawField = new JFormattedTextField(NumberFormat.getCurrencyInstance());
      withdrawField.setEditable(true);
      withdrawField.setValue(0.0);
      withdrawField.setColumns(10); // initial width of 10  
      withdrawField.addActionListener(this);

      // Use a GridBagLayout
      setLayout(new GridBagLayout());

      // Specify component's grid location
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 10, 1);
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      add(withdrawlLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 1, 10, 10);
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      add(withdrawField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 5, 10, 10);
      layoutConst.gridx = 2;
      layoutConst.gridy = 0;
      add(withdrawlButton, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 0, 1, 10);
      layoutConst.gridx = 1;
      layoutConst.gridy = 1;
      add(balanceLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 0, 10, 10);
      layoutConst.gridx = 1;
      layoutConst.gridy = 2;
      add(balanceField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 0, 1, 10);
      layoutConst.gridx = 2;
      layoutConst.gridy = 1;
      add(accountIDLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 0, 10, 10);
      layoutConst.gridx = 2;
      layoutConst.gridy = 2;
      add(accountIDField, layoutConst);
   }

   /* method called with button is clicked or enter is pressed in the withdraw field */
   @Override
   public void actionPerformed(ActionEvent event) {
      double withAmount;     // amount to withdraw
      double curBal;       // current balance placeholder

      // Get value from withdraw field
      withAmount = ((Number) withdrawField.getValue()).doubleValue();
      curBal = ((Number) balanceField.getValue()).doubleValue();
      if (withAmount >= 0.0) {
         curBal = curBal - withAmount;
         if (curBal < 0.0) {
            JOptionPane.showMessageDialog(this, "Cannot withdrawl, balancce would be negative!");
            withdrawField.setValue(0.0);

         }
         if (curBal >= 0.0) {
         JOptionPane.showMessageDialog(this, "Money withdrawn, new balance is: $" + curBal);
         balanceField.setText(Double.toString(curBal));
         withdrawField.setValue(0.0);
         }
      }
      else {
         // Show failure dialog
         JOptionPane.showMessageDialog(this, "Please enter a valid number.");
      }
   }

   /* Creates a BankAccountGui and makes it visible */
   public static void main(String[] args) {
      //prompts user for balance and account id
      String accountInput = JOptionPane.showInputDialog(null, "Enter Account ID:");
      String balanceInput = JOptionPane.showInputDialog(null, "Enter Starting Balance:");

      double startingBalance = Double.parseDouble(balanceInput);


      // Creates BankAccountGui and its components
      BankAccountGui myFrame = new BankAccountGui(accountInput, startingBalance);
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
   }
}