import java.util.Scanner;

public class Account {
    //Class variables
    int balance;
    int previousTransation;
    String customerName;
    String customerID;

    //Class constructor
    Account(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    //Function for depositing money
    void deposit(int amount) {
        if(amount != 0) {
            balance = balance + amount;
            previousTransation = amount;
        }
    }

    //Function for withdrawing money
    void withdraw(int amount) {
        if(amount !=0){
            balance = balance - amount;
            previousTransation = -amount;
        }
    }

    void  getPreviousTransation() {
        if (previousTransation > 0) {
            System.out.println("Deposited: " + previousTransation);
        } else if (previousTransation < 0) {
            System.out.println("withdrawn: " + Math.abs(previousTransation));
        } else {
            System.out.println("No transaction occured");
        }
    }

    void calculateInterest (int years) {
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName +"!");
        System.out.println("Your ID:" + customerID);
        System.out.println();
        System.out.println("What would ou like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an Option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch(option) {
                case 'A':
                System.out.println("=======================");
                System.out.println("Balance = £" + balance);
                System.out.println("=======================");
                System.out.println();
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("=======================");
                    getPreviousTransation();
                    System.out.println("=======================");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                case 'F':
                    System.out.println("=======================");
                    break;
                default:
                    System.out.println("Error: invalid option. Please select A, B, C, D, E or F");
            }
        } while(option != 'F');
        System.out.println("Thank you for banking with us!");
    }
}
