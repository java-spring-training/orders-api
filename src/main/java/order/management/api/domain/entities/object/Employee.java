package order.management.api.domain.entities.object;

import order.management.api.domain.value.object.EmployeeNumber;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Employee
 */
public class Employee {
    @NotNull
    private EmployeeNumber employeeNumber;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String extension;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String officeCode;

    @NotEmpty
    private EmployeeNumber reportsTo;

    @NotEmpty
    private String jobTitle;

    public Employee(@NotNull EmployeeNumber employeeNumber, @NotEmpty String lastName, @NotEmpty String firstName,
            @NotEmpty String extension, @NotEmpty @Email String email, @NotEmpty String officeCode,
            @NotEmpty EmployeeNumber reportsTo, @NotEmpty String jobTitle) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
    }

    public EmployeeNumber getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(EmployeeNumber employeeNumber) {
        this.employeeNumber = employeeNumber;
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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public EmployeeNumber getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(EmployeeNumber reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
