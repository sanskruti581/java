import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Bank b = new Bank();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Divide Balance");
            System.out.println("5. Exit");
            System.out.println("6. try catch by 0");
             System.out.println("7.length of string");
            System.out.println("Enter your choice:");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    try {
                        b.deposit();
                    } catch (AmountDeposit e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        b.withdraw();
                    } catch (AmountWithdraw e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println("**END OF WITHDRAWAL**");
                    }
                    break;


                case 3:
                    b.checkBalance();
                    break;

                case 4:
                    b.divideBalance1();
                    break;

                case 5:
                    System.out.println("Exiting the system...");
                    break;
                    
                 case 6:
                  b.divideBalance1();
                  
                  case 7:
                  String s = null;
                  
                  try{
                  System.out.println(s.length());
                  }catch(NullPointerException e){
                   System.out.println(e);
                  }
                  
                  
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }

        } while (choice != 5);

       
    }
}

class Bank {
    private int balance = 0;


    public void withdraw() throws AmountWithdraw {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER AMOUNT TO WITHDRAW:");
        int withdrawAmount = sc.nextInt();

        if (withdrawAmount > balance) {
            throw new AmountWithdraw("INSUFFICIENT BALANCE!");
        } else {
            balance -= withdrawAmount;
            System.out.println("WITHDRAWAL SUCCESS! Remaining Balance: " + balance);
        }
    }

    public void deposit() throws AmountDeposit {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER AMOUNT TO DEPOSIT:");
        int depositAmount = sc.nextInt();

        if (depositAmount < 0) {
            throw new AmountDeposit("AMOUNT CANNOT BE NEGATIVE!");
        } else {
            balance += depositAmount;
            System.out.println("DEPOSIT SUCCESS! Updated Balance: " + balance);
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    
    public void divideBalance1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER NUMBER TO DIVIDE BALANCE:");
        int divisor = sc.nextInt();

      
            int result = balance / divisor;
            System.out.println("RESULT: " + result);
      
    }
}

class AmountWithdraw extends Exception {
    AmountWithdraw(String message) {
        super(message);
    }
}

class AmountDeposit extends Exception {
    AmountDeposit(String message) {
        super(message);
    }
}
