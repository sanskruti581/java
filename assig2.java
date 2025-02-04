import java.util.*;
import java.io.*;

class Doctor {
    String drname;
    
  /*  Doctor(String drname){
     drname=this.drname;
    } */

    void accept() {
        System.out.println("ENTER NAME OF DOCTOR: ");
        Scanner sc = new Scanner(System.in);
        drname = sc.nextLine();
        
    }
}

class Nurse extends Doctor {
    String Nname;

    void insert() {
        System.out.println("ENTER NAME OF NURSE: ");
        Scanner sc = new Scanner(System.in);
        Nname = sc.nextLine();
    }
}

class Assistant extends Nurse {
    String Aname;

    void accept1() {
        super.accept();
        super.insert();
        System.out.println("ENTER NAME OF ASSISTANT: ");
        Scanner sc = new Scanner(System.in);
        Aname = sc.nextLine();
        displayInfo();
    }

    void displayInfo() {
        System.out.println("Doctor's Name: " + drname);
        System.out.println("Nurse's Name: " + Nname);
        System.out.println("Assistant's Name: " + Aname);
    }
}

 class Assig2 {
    public static void main(String[] args) {
        Assistant assistant = new Assistant();
        
        System.out.println("ENTER EITHER YOU ARE A DOCTOR (1),NURSE(2) OR A ASSISTANT(3) for exit(0)");
        Scanner sc=new Scanner(System.in);
        int ch=sc.nextInt();
        
        while(ch!=0){
          switch(ch){
           case 1:
           assistant.accept();
           break;
           
           case 2:
           assistant.insert();
           break;
           
           case 3:
           assistant.accept1();
           break;
           
           case 0:
           System.out.println("EXITING FROM THE CODE \n");
           
           default:
           System.out.println("PLEASE ENTERR A VALID CHOICE");
           
          } 
        
        }
        
    }
}

