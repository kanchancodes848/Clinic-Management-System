public abstract class Person {
    protected String firstName; // first name of person
    protected String lastName; // last name of person
    protected String address; // address of person

    public Person(String firstName, String lastName, String address) {
        this.firstName = firstName; // set first name
        this.lastName = lastName; // set last name
        this.address = address; // set address
    }

    public String getLastName() {
        return lastName; // return last name
    }

    public abstract void printInfo(); // force subclasses to print details
}
