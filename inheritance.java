import java.util.Scanner;

class Person {
    public:
    String name;
    String mobileNo;

    // Parameterized Constructor
    Person(Scanner sc) {
        System.out.print("Enter Name: ");
        this.name = sc.nextLine();

        while (true) {
            System.out.print("Enter Mobile Number (10 digits): ");
            this.mobileNo = sc.next();
            if (this.mobileNo.length() == 10 && this.mobileNo.matches("\\d+")) {
                sc.nextLine(); // Consume newline
                break;
            }
            System.out.println("Invalid mobile number! Enter exactly 10 digits.");
            sc.nextLine(); // Clear invalid input
        }
    }

    void displayDetails() {
        System.out.println("Name: " + this.name);
        System.out.println("Mobile: " + this.mobileNo);
    }
}

class Doctor extends Person {
    int wardNo;
    String dept;

    // Parameterized Constructor
    Doctor(Scanner sc) {
        super(sc); // Call Person constructor

        while (true) {
            System.out.print("Enter Ward Number (1-12): ");
            if (sc.hasNextInt()) {
                this.wardNo = sc.nextInt();
                if (this.wardNo >= 1 && this.wardNo <= 12) {
                    sc.nextLine(); // Consume newline
                    break;
                }
            }
            System.out.println("Invalid ward! Only 12 wards available. Try again.");
            sc.nextLine(); // Clear invalid input
        }

        while (true) {
            System.out.print("Enter Department (ORTHO / NEURO / GYNAC): ");
            this.dept = sc.nextLine().toUpperCase();
            if (this.dept.equals("ORTHO") || this.dept.equals("NEURO") || this.dept.equals("GYNAC")) {
                break;
            }
            System.out.println("Invalid department! Choose from ORTHO, NEURO, GYNAC.");
        }
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Ward No: " + this.wardNo);
        System.out.println("Department: " + this.dept);
    }
}

class SpecialistDoctor extends Doctor {
    String specialization;

    // Parameterized Constructor
    SpecialistDoctor(Scanner sc) {
        super(sc); // Call Doctor constructor
        assignSpecialization();
    }

    void assignSpecialization() {
        switch (this.dept) {
            case "ORTHO":
                this.specialization = "Bone & Joint Specialist";
                break;
            case "NEURO":
                this.specialization = "Brain & Nervous System Specialist";
                break;
            default:
                this.specialization = "Women's Health Specialist";
        }
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Specialization: " + this.specialization);
    }
}

public class DoctorDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of doctors: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        SpecialistDoctor[] doctors = new SpecialistDoctor[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEntering details for Doctor " + (i + 1) + ":");
            doctors[i] = new SpecialistDoctor(sc); // Call parameterized constructor
        }

        System.out.println("\nDisplaying all Doctor details:");
        for (SpecialistDoctor doctor : doctors) {
            doctor.displayDetails();
            System.out.println("----------------------------");
        }

        sc.close();
    }
}
