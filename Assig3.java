import java.util.Scanner;


interface Calculations {
    int result(int a, int b);
}


interface IsNegative {
    void checkNegative(int no);
}

class Addition implements Calculations {
    public int result(int x, int y) {
        return x + y;
    }
}


class Subtraction implements Calculations {
    public int result(int p, int q) {
        return p - q;
    }
}

class Multiplication implements Calculations {
    public int result(int r, int s) {
        return r * s;
    }
}


class Division implements Calculations {
    public int result(int w, int n) {
        if (n == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return 0;
        }
        return w / n;
    }
}


class CheckNP implements IsNegative {
    public void checkNegative(intt no) {
        if (no < 0) {
            System.out.println("The number " + no + " is NEGATIVE.");
        } else {
            System.out.println("The number " + no + " is POSITIVE.");
        }
    }
}


public class Assig3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("\nENTER YOUR CHOICE:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Check Negative Number");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    Addition addObj = new Addition();
                    System.out.print("Enter first number: ");
                    int a = sc.nextInt();
                    System.out.print("Enter second number: ");
                    int b = sc.nextInt();
                    System.out.println("Result: " + addObj.result(a, b));
                    break;

                case 2:
                    Subtraction subObj = new Subtraction();
                    System.out.print("Enter first number: ");
                    int ac = sc.nextInt();
                    System.out.print("Enter second number: ");
                    int bc = sc.nextInt();
                    System.out.println("Result: " + subObj.result(ac, bc));
                    break;

                case 3:
                    Multiplication mulObj = new Multiplication();
                    System.out.print("Enter first number: ");
                    int an = sc.nextInt();
                    System.out.print("Enter second number: ");
                    int bn = sc.nextInt();
                    System.out.println("Result: " + mulObj.result(an, bn));
                    break;

                case 4:
                    Division divObj = new Division();
                    System.out.print("Enter first number: ");
                    int aq = sc.nextInt();
                    System.out.print("Enter second number: ");
                    int bq = sc.nextInt();
                    System.out.println("Result: " + divObj.result(aq, bq));
                    break;

                case 5:
                    CheckNP checkObj = new CheckNP();
                    System.out.print("Enter a number to check: ");
                    int a1 = sc.nextInt();
                    checkObj.checkNegative(a1);
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (ch != 0);

        sc.close();
    }
}

