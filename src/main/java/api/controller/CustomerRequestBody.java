package api.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

public class CustomerRequestBody {

    @Min(value = 0, message = "customerNumber is invalid")
    @NotNull(message = "customerNumber must not be null")
    private Integer customerNumber;
    @NotEmpty(message = "customerName must not be empty")
    private String customerName;
    @NotEmpty(message = "contactLastName must not be empty")
    private String contactLastName;
    @NotEmpty(message = "contactFirstName must not be empty")
    private String contactFirstName;
    @NotEmpty(message = "phone must not be empty")
    @Pattern(regexp = "\\d{1,11}", message = "phone is invalid")
    private String phone;
    @NotEmpty(message = "addressLine1 must not be empty")
    private String addressLine1;
    private String addressLine2;
    @NotEmpty(message = "city must not be empty")
    private String city;
    private String state;
    @Pattern(regexp = "\\d{1,10}", message = "postalCode must be number")
    private String postalCode;
    @NotEmpty(message = "country must not be empty")
    private String country;
    @Min(value = 0)
    private Integer salesRepEmployeeNumber;
    @Min(value = 0)
    private BigDecimal creditLimit;

    public CustomerRequestBody() {
    }

    public CustomerRequestBody(Integer customerNumber, String customerName, String contactLastName,
                               String contactFirstName, String phone, String addressLine1, String addressLine2, String city,
                               String state, String postalCode, String country, Integer salesRepEmployeeNumber,
                               BigDecimal creditLimit) {

        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
        this.creditLimit = creditLimit;
    }

    public Integer getCustomerNumber() {

        return customerNumber;
    }

    public String getCustomerName() {

        return customerName;
    }

    public String getContactLastName() {

        return contactLastName;
    }

    public String getContactFirstName() {

        return contactFirstName;
    }

    public String getPhone() {

        return phone;
    }

    public String getAddressLine1() {

        return addressLine1;
    }

    public String getAddressLine2() {

        return addressLine2;
    }

    public String getCity() {

        return city;
    }

    public String getState() {

        return state;
    }

    public String getPostalCode() {

        return postalCode;
    }

    public String getCountry() {

        return country;
    }

    public Integer getSalesRepEmployeeNumber() {

        return salesRepEmployeeNumber;
    }

    public BigDecimal getCreditLimit() {

        return creditLimit;
    }
}
