import java.util.Scanner;

class DoctorDetails {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Doctor's Name: ");
        String name = sc.nextLine();

        int wardNo;
        while (true) {
            System.out.print("Enter Ward Number (1-12): ");
            if (sc.hasNextInt()) {
                wardNo = sc.nextInt();
                if (wardNo >= 1 && wardNo <= 12) {
                    break;
                }
            }
            System.out.println("Invalid ward! Only 12 wards available. Try again.");
            sc.nextLine(); // Clear invalid input
        }

        String mobileNo;
        while (true) {
            System.out.print("Enter Mobile Number (10 digits): ");
            mobileNo = sc.next();
            if (mobileNo.length() == 10 && mobileNo.matches("\\d+")) {
                break;
            }
            System.out.println("Invalid mobile number! Enter exactly 10 digits.");
        }

        sc.nextLine(); // Consume newline

        String dept;
        while (true) {
            System.out.print("Enter Department (ORTHO / NEURO / GYNAC): ");
            dept = sc.nextLine().toUpperCase();
            if (dept.equals("ORTHO") || dept.equals("NEURO") || dept.equals("GYNAC")) {
                break;
            }
            System.out.println("Invalid department! Choose from ORTHO, NEURO, GYNAC.");
        }

        System.out.println("\n***** Doctor Details *****");
        System.out.println("Name: " + name);
        System.out.println("Ward No: " + wardNo);
        System.out.println("Mobile: " + mobileNo);
        System.out.println("Department: " + dept);

        if (dept.equals("ORTHO")) {
            System.out.println("Specialization: Bone & Joint Specialist.");
        } else if (dept.equals("NEURO")) {
            System.out.println("Specialization: Brain & Nervous System Specialist.");
        } else {
            System.out.println("Specialization: Women's Health Specialist.");
        }

        sc.close();
    }
}
