import java.util.Scanner;

public class multiply {
        
    public static long multiplyInts(Scanner input, int count) { //recursively multiplies 5 numbers entered by the user
        
        if (count == 0) {
                return 1; //base case, once the last number is entered, the count will be decreased and the recusrion will stop
            }
            else {
                return input.nextLong() * multiplyInts(input, count -1); //recursive case and moving toward the base case. grabs the next long from the input scanner to multiply and then calls the method again
            }
        }       
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //setting up input for colleccting numbers
        System.out.println("Enter 5 numbers, one at a time:"); 
        System.out.print(multiplyInts(input, 5)); //starts off the method with the initial input, and a counter for the 5 numbers
    }
}
