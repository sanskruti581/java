import java.util.Scanner;

abstract class Displayable {
    abstract void displayDetails();
}

class Person extends Displayable {
    String name;
    String mobileNo;
    static Scanner sc = new Scanner(System.in);

    Person() {
        System.out.print("Enter Name: ");
        this.name = sc.nextLine();

        System.out.print("Enter Mobile Number (10 digits): ");
        this.mobileNo = sc.nextLine().trim();
        while (!this.mobileNo.matches("\\d{10}")) {
            System.out.println("Invalid mobile number! Enter exactly 10 digits.");
            System.out.print("Enter Mobile Number: ");
            this.mobileNo = sc.nextLine();
        }
    }

    public void displayDetails() {
        System.out.println("Name: " + this.name);
        System.out.println("Mobile: " + this.mobileNo);
    }
}

class Doctor extends Person {
    int wardNo;
    protected String dept;

    Doctor() {
        super();
        this.wardNo = inputWardNumber();

        
    }

    private int inputWardNumber() {
        while (true) {
            System.out.print("Enter Ward Number (1-12): ");
            if (sc.hasNextInt()) {
                int ward = sc.nextInt();
            
                if (ward >= 1 && ward <= 12) {
                    return ward;
                }
            }
            System.out.println("Invalid ward! Only 12 wards available. Try again.");
            sc.nextLine(); 
        }
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Ward No: " + this.wardNo);
        
    }
}

class Nurse extends Person {
    String nurseId;

    Nurse() {
        super();
        System.out.print("Enter Nurse ID: ");
        this.nurseId = sc.nextLine();
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Nurse ID: " + this.nurseId);
    }
}

class Assistant extends Person {
   private final String assistantId;

    Assistant() {
        super();
        System.out.print("Enter Assistant ID: ");
        this.assistantId = sc.nextLine().trim();
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Assistant ID: " + assistantId);
    }
}

public class assig2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose a role to enter details:");
            System.out.println("1. Doctor\n2. Nurse\n3. Assistant\n4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("ENTER NO OF DETAILS YOU WANT TO ENTER FOR DOCTOR");
                    int n = sc.nextInt();
                    
                    for (int i = 0; i < n; i++) {
                        Doctor doctor = new Doctor();
                        doctor.displayDetails();
                    }
                    break;

                case 2:
                    System.out.println("ENTER NO OF NURSE DETAILS YOU WANT TO ENTER");
                    int n1 = sc.nextInt();
      
                    for (int i = 0; i < n1; i++) {
                        Nurse nurse = new Nurse();
                        nurse.displayDetails();
                    }
                    break;

                case 3:
                    System.out.println("ENTER THE NO OF DETAILS YOU WANT TO ENTER FOR ASSISTANT");
                    int n2 = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n2; i++) {
                        Assistant assistant = new Assistant();
                        assistant.displayDetails();
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    Person.sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
