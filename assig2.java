import java.util.Scanner;

interface Displayable {
    void displayDetails();
}

class Person implements Displayable {
    String name;
    String mobileNo;
    static Scanner sc = new Scanner(System.in);

    // Constructor
    Person() {
        System.out.print("Enter Name: ");
        this.name = sc.nextLine();

        System.out.print("Enter Mobile Number (10 digits): ");
        this.mobileNo = sc.nextLine();
        while (!this.mobileNo.matches("\\d{10}")) {
            System.out.println("Invalid mobile number! Enter exactly 10 digits.");
            System.out.print("Enter Mobile Number: ");
            this.mobileNo = sc.nextLine();
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + this.name);
        System.out.println("Mobile: " + this.mobileNo);
    }
}

class Doctor extends Person {
    int wardNo;
    String dept;

    // Constructor
    Doctor() {
        super(); // Call Person constructor
        
        while (true) {
            System.out.print("Enter Ward Number (1-12): ");
            if (sc.hasNextInt()) {
                this.wardNo = sc.nextInt();
                sc.nextLine(); // Consume newline
                if (this.wardNo >= 1 && this.wardNo <= 12) {
                    break;
                }
            }
            System.out.println("Invalid ward! Only 12 wards available. Try again.");
            sc.nextLine(); // Clear invalid input
        }

        System.out.print("Enter Department: ");
        this.dept = sc.nextLine().toUpperCase();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Ward No: " + this.wardNo);
        System.out.println("Department: " + this.dept);
    }
}

class Nurse extends Person {
    String nurseId;

    // Constructor
    Nurse() {
        super(); // Call Person constructor
        System.out.print("Enter Nurse ID: ");
        this.nurseId = sc.nextLine();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Nurse ID: " + this.nurseId);
    }
}

class Assistant extends Person {
    String assistantId;

    // Constructor
    Assistant() {
        super(); // Call Person constructor
        System.out.print("Enter Assistant ID: ");
        this.assistantId = sc.nextLine();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Assistant ID: " + this.assistantId);
    }
}

public class Assig2 {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Choose a role to enter details:");
            System.out.println("1. Doctor\n2. Nurse\n3. Assistant\n4. Exit");
            int choice = Person.sc.nextInt();
            Person.sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Doctor doctor = new Doctor();
                    doctor.displayDetails();
                    break;
                case 2:
                    Nurse nurse = new Nurse();
                    nurse.displayDetails();
                    break;
                case 3:
                    Assistant assistant = new Assistant();
                    assistant.displayDetails();
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
