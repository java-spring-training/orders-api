package order.controller.results.object;

public class EmployeeResult {
    private int employeeNumber;
    private String email;

    public EmployeeResult(int employeeNumber, String email) {
        this.employeeNumber = employeeNumber;
        this.email = email;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getEmail() {
        return email;
    }
}