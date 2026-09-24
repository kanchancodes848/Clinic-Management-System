public class Employee extends Person {
    private double salary; // monthly salary
    private int hoursWorked; // hours worked in a month

    public Employee(String firstName, String lastName, String address, double salary, int hoursWorked) {
        super(firstName, lastName, address); // call parent constructor
        this.salary = salary; // set salary
        this.hoursWorked = hoursWorked; // set hours worked
    }

    public double calculatePaycheck() {
        if (hoursWorked <= 165) { // if hours ≤ 165
            return salary; // no overtime
        } else {
            int overtime = hoursWorked - 165; // extra hours
            double overtimePay = (salary / 165) * 1.5 * overtime; // overtime pay
            return salary + overtimePay; // total pay
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Employee's information:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Salary Rate: $" + salary);
        System.out.println("Hours: " + hoursWorked);
        System.out.println("Paid: $" + String.format("%.2f", calculatePaycheck()));
        System.out.print("========================\n========================\n"); // formatting
    }
}
