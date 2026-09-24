
// Name: Kanchan Kadariya
// CSIT 211
// Lab 1 - Clinic Management System

import java.util.*;

public class Clinic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create staff list
        ArrayList<Person> staff = new ArrayList<>();

        // Create 3 doctors
        Doctor d1 = new Doctor("Elina", "Rai", "123 St", "PCP", 100);
        Doctor d2 = new Doctor("John", "Blake", "456 St", "Dermatologist", 150);
        Doctor d3 = new Doctor("Sara", "Frost", "789 St", "Pediatric", 150);

        // Create 2 employees
        Employee e1 = new Employee("John", "Jones", "321 St", 2000, 170);
        Employee e2 = new Employee("James", "Harison", "654 St", 3209, 160);

        // Add all staff
        staff.add(d1);
        staff.add(d2);
        staff.add(d3);
        staff.add(e1);
        staff.add(e2);

        // Store patients
        ArrayList<Patient> patients = new ArrayList<>();

        // Store doctors who actually see patients
        ArrayList<Doctor> visitedDoctors = new ArrayList<>();

        // Patient check-in loop
        while (true) {

            String isNew;

            // Ask whether patient is new
            while (true) {
                System.out.println(
                        "\nIs this a new Patient? (yes/no):");

                isNew = sc.nextLine().trim().toLowerCase();

                if (isNew.equals("yes") || isNew.equals("no")) {
                    break;
                }

                System.out.println(
                        "Invalid input! Please type yes or no.");
            }

            Patient currentPatient = null;

            if (isNew.equals("yes")) {

                // Collect new patient information
                System.out.println("Patient's first name:");
                String fName = sc.nextLine().trim();

                System.out.println("Patient's last name:");
                String lName = sc.nextLine().trim();

                System.out.println("Patient's address:");
                String address = sc.nextLine().trim();

                System.out.println("Patient's primary care doctor:");
                String pcp = sc.nextLine().trim();

                // Create and save patient
                currentPatient = new Patient(
                        fName, lName, address, pcp);

                patients.add(currentPatient);

            } else {

                // Find an existing patient
                System.out.println("Patient's last name:");
                String lName = sc.nextLine().trim();

                for (Patient p : patients) {

                    if (p.getLastName().equalsIgnoreCase(lName)) {
                        currentPatient = p;
                        break;
                    }
                }
            }

            if (currentPatient == null) {
                System.out.println("Patient not found!");
                continue;
            }

            // Ask which doctor the patient is visiting today
            System.out.println("Doctor's name:");
            String docName = sc.nextLine().trim();

            Doctor visitingDoc = null;
            Doctor primaryDoc = null;

            // Find both doctors
            for (Person p : staff) {

                if (p instanceof Doctor) {

                    Doctor doc = (Doctor) p;

                    // Accept first name or last name
                    if (doc.firstName.equalsIgnoreCase(docName)
                            || doc.getLastName()
                                    .equalsIgnoreCase(docName)) {

                        visitingDoc = doc;
                    }

                    String pcpName = currentPatient.getPrimaryCareDoctor().trim();

                    if (doc.firstName.equalsIgnoreCase(pcpName)
                            || doc.getLastName()
                                    .equalsIgnoreCase(pcpName)) {

                        primaryDoc = doc;
                    }
                }
            }

            // Record the actual appointment
            if (visitingDoc != null) {

                visitingDoc.addVisit();

                currentPatient.visit(
                        visitingDoc.getLastName());

                // Add doctor to final payment summary
                if (!visitedDoctors.contains(visitingDoc)) {
                    visitedDoctors.add(visitingDoc);
                }

                // Print patient visit report
                System.out.println(
                        "\n================================");
                System.out.println(
                        "       PATIENT VISIT REPORT");
                System.out.println(
                        "================================");

                System.out.println(
                        "Patient: " + currentPatient.firstName
                                + " " + currentPatient.getLastName());

                // Display primary care doctor
                if (primaryDoc != null) {

                    System.out.println(
                            "Primary care doctor: Dr. "
                                    + primaryDoc.firstName + " "
                                    + primaryDoc.getLastName());

                } else {

                    System.out.println(
                            "Primary care doctor: "
                                    + currentPatient.getPrimaryCareDoctor());
                }

                // Display actual visiting doctor
                System.out.println(
                        "Doctor visited: Dr. "
                                + visitingDoc.firstName + " "
                                + visitingDoc.getLastName());

                // Display the fee for this appointment
                double appointmentFee;

                if (visitingDoc == d1) {
                    appointmentFee = 100;
                } else {
                    appointmentFee = 150;
                }

                System.out.printf(
                        "Appointment fee: $%.2f%n",
                        appointmentFee);

                System.out.println(
                        "Status: Successfully checked in");

                System.out.println(
                        "================================");

            } else {

                System.out.println("Doctor not found!");
            }

            // Ask whether there are more patients
            String more;

            while (true) {

                System.out.println(
                        "\nMore patient? (yes/no):");

                more = sc.nextLine().trim().toLowerCase();

                if (more.equals("yes") || more.equals("no")) {
                    break;
                }

                System.out.println(
                        "Invalid input! Please type yes or no.");
            }

            if (more.equals("no")) {
                break;
            }
        }

        // Print payment summary for doctors
        // who actually had appointments
        System.out.println(
                "\n================================");
        System.out.println(
                "       DOCTOR PAYMENT SUMMARY");
        System.out.println(
                "================================");

        if (visitedDoctors.isEmpty()) {

            System.out.println(
                    "No doctor visits recorded.");

        } else {

            for (Doctor doc : visitedDoctors) {
                doc.printInfo();
            }
        }

        sc.close();
    }
}