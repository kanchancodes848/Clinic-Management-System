public class Doctor extends Person {
    private String specialty;   // doctor's specialty
    private double visitFee;    // fee per visit
    private int visits;         // number of visits

    public Doctor(String firstName, String lastName, String address, String specialty, double visitFee) {
        super(firstName, lastName, address); // call parent constructor
        this.specialty = specialty;          // set specialty
        this.visitFee = visitFee;            // set visit fee
        this.visits = 0;                     // start visits with 0
    }

    public void addVisit() {
        visits++;   // increase visit count
    }

    public double calculatePay() {
        return visits * visitFee;   // total pay = visits × fee
    }

    @Override
    public void printInfo() {
        System.out.println("Doctor's information:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Specialty: " + specialty);
        System.out.println("Office visit fee: $" + visitFee);
        System.out.println("Number of visits: " + visits);
        System.out.println("Paid: $" + calculatePay());
        System.out.print("========================\n========================\n"); 
    }
}
