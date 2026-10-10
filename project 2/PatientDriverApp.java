import java.util.Scanner;

// Written by Kelvin Zimmerman on 9 Oct. 2026 for CMSC 203
// This class serves as the driver application for managing patient and procedure information.
// It collects patient details, creates procedure instances, and displays a summary of the procedures performed.

public class PatientDriverApp {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Patient patient = inputPatient(in);

        displayPatient(patient);

        Procedure first = createProcedure1(); first.setProcedureName("Physical Exam"); first.setPractitioner("Dr. Irvine"); first.setCost(250.00); first.setProcedureDate("09/30/2026");
        Procedure second = createProcedure2(); second.setPractitioner("Dr. Jamison"); second.setCost(550.43);
        Procedure third = createProcedure3();

        displayProcedureTable(first, second, third);

        displaySummary(first, second, third);

        System.out.println("This program was developed by a Student: Kelvin Zimmerman 10/09/26");
    }

    public static Patient inputPatient(Scanner input){
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter middle name: ");
        String middleName = input.nextLine();
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        System.out.print("Enter address: ");
        String address = input.nextLine();
        System.out.print("Enter city: ");
        String city = input.nextLine();
        System.out.print("Enter state: ");
        String state = input.nextLine();
        System.out.print("Enter zip code: ");
        String zipCode = input.nextLine();
        System.out.print("Enter phone number (###-###-####): ");
        String phoneNumber = input.nextLine();
        System.out.print("Enter emergency contact name: ");
        String emergencyContact = input.nextLine();
        System.out.print("Enter emergency contact phone number (###-###-####): ");
        String emergencyContactPhone = input.nextLine();

        return new Patient(firstName, middleName, lastName, address, zipCode, city, state, phoneNumber, emergencyContact, emergencyContactPhone);
    }

    public static Procedure createProcedure1(){
        return new Procedure();
    }

    public static Procedure createProcedure2(){
        return new Procedure("X-Ray", "10/01/2026"); // uses the two-arg constructor
    }

    public static Procedure createProcedure3(){
        return new Procedure("Blood Test", "10/02/2026", "Dr. Irvine", 1500.37); // uses the all-args constructor
    }

    public static void displayProcedure(Procedure procedure){
        System.out.println(procedure.toString());
    }

    public static void displayPatient(Patient patient){
        System.out.println("Patient Information:");
        System.out.println("-------------------");
        System.out.println(patient.toString());
        System.out.println("Phone Valid: " + patient.isValidPhoneNumber(patient.getPhoneNumber()));
        System.out.println("Emergency Contact Phone Valid: " + patient.isValidPhoneNumber(patient.getEmergencyContactPhone()));
    }

    public static void displayProcedureTable(Procedure procedure1, Procedure procedure2, Procedure procedure3){
        System.out.println(String.format("%-19s %-13s %-21s %9s %s", "Procedure", "Date", "Practitioner", "Cost", "Category"));
        System.out.println("------------------------------------------------------------------------");
        displayProcedure(procedure1);
        displayProcedure(procedure2);
        displayProcedure(procedure3);
    }

    public static double calculateTotalCharges(Procedure procedure1, Procedure procedure2, Procedure procedure3){
        return procedure1.getCost() + procedure2.getCost() + procedure3.getCost();
    }

    public static double calculateAverageCharge(Procedure procedure1, Procedure procedure2, Procedure procedure3){
        return calculateTotalCharges(procedure1, procedure2, procedure3) / 3;
    }

    public static Procedure findHighestChargeProcedure(Procedure procedure1, Procedure procedure2, Procedure procedure3){
        if(procedure1.getCost() >= procedure2.getCost() && procedure1.getCost() >= procedure3.getCost()){
            return procedure1;
        } else if(procedure2.getCost() >= procedure1.getCost() && procedure2.getCost() >= procedure3.getCost()){
            return procedure2;
        } else {
            return procedure3;
        }
    }

    public static int countExpensiveProcedures(Procedure procedure1, Procedure procedure2, Procedure procedure3){
        int count = 0;
        if(procedure1.isExpensiveProcedure()){
            count++;
        }
        if(procedure2.isExpensiveProcedure()){
            count++;
        }
        if(procedure3.isExpensiveProcedure()){
            count++;
        }
        return count;
    }

    public static void displaySummary(Procedure procedure1, Procedure procedure2, Procedure procedure3){
        double totalCharges = calculateTotalCharges(procedure1, procedure2, procedure3);
        double averageCharge = calculateAverageCharge(procedure1, procedure2, procedure3);
        String highestChargeProcedure = findHighestChargeProcedure(procedure1, procedure2, procedure3).getProcedureName();
        int expensiveProcedureCount = countExpensiveProcedures(procedure1, procedure2, procedure3);
        System.out.println(String.format("Total Charges: $%,.2f", totalCharges));
        System.out.println(String.format("Average Charge: $%,.2f", averageCharge));
        System.out.println("Highest Charge Procedure: " + highestChargeProcedure);
        System.out.println("Number of Expensive Procedures: " + expensiveProcedureCount);
    }
}
