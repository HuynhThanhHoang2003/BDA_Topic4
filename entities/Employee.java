package sales.entities;

public class Employee {
    private int id;
    private String lastName;
    private String firstName;
    private String birthName;
    private int supervisor;

    public Employee(){}

    public Employee(int id, String lastName, String firstName, String birthName, int supervisor) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthName = birthName;
        this.supervisor = supervisor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthName() {
        return birthName;
    }

    public void setBirthName(String birthName) {
        this.birthName = birthName;
    }

    public int getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(int supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %-6d | Last Name: %-15s | First Name: %-15s | Birth Name: %-15s | Supervisor: %-6d",
                id,
                lastName,
                firstName,
                birthName,
                supervisor
        );
    }
}