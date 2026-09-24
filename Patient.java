public class Patient extends Person {
    private String primaryCareDoctor;   // primary care doctor
    private String lastVisitedDoctor;   // last visited doctor

    public Patient(String firstName, String lastName, String address, String primaryCareDoctor) {
        super(firstName, lastName, address);   // call parent constructor
        this.primaryCareDoctor = primaryCareDoctor; // set primary doctor
        this.lastVisitedDoctor = null;             // no doctor visited yet
    }

    public void visit(String doctorName) {
        this.lastVisitedDoctor = doctorName;   // set last visited doctor
    }

    public String getPrimaryCareDoctor() {
        return primaryCareDoctor;   // return primary doctor
    }

    @Override
    public void printInfo() {
        System.out.println("Patient's information:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Primary Care Doctor: " + primaryCareDoctor);
        System.out.println("Last Visited Doctor: " + lastVisitedDoctor);
        System.out.print("========================\n========================\n"); // formatting
    }
}
