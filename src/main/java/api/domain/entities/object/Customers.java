package api.domain.entities.object;

import api.domain.value.object.CustomerNumber;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public class Customers {

    private CustomerNumber customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private Integer salesRepEmployeeNumber;
    private BigDecimal creditLimit;

    public Customers(CustomerNumber customerNumber, String customerName, String contactLastName,
                     String contactFirstName, String phone, String addressLine1, String addressLine2, String city,
                            String state, String postalCode, String country, Integer salesRepEmployeeNumber,
                                    BigDecimal creditLimit) {

        this.checkValidation(customerName, contactLastName, contactFirstName, phone, addressLine1, city, postalCode,
                country, creditLimit);

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

    public CustomerNumber getCustomerNumber() {

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

    private void checkValidation(final String customerName, final String contactLastName, final String contactFirstName,
                 final String phone, final String addressLine1, final String city, final String postalCode,
                            final String country, final BigDecimal creditLimit) {

        if (StringUtils.isEmpty(customerName)) {
            throw new IllegalArgumentException("customerName must not be empty");
        }

        if (StringUtils.isEmpty(contactLastName)) {
            throw new IllegalArgumentException("contactLastName must not be empty");
        }

        if (StringUtils.isEmpty(contactFirstName)) {
            throw new IllegalArgumentException("contactFirstName must not be empty");
        }

        if (StringUtils.isEmpty(phone)) {
            throw new IllegalArgumentException("phone must not be empty");
        }

        if (!phone.matches("\\d{1,11}")) {
            throw new IllegalArgumentException("phone is invalid");
        }

        if (StringUtils.isEmpty(addressLine1)) {
            throw new IllegalArgumentException("addressLine1 must not be empty");
        }

        if (StringUtils.isEmpty(city)) {
            throw new IllegalArgumentException("city must not be empty");
        }

        if (!(StringUtils.isEmpty(postalCode) || postalCode.matches("\\d{1,10}"))) {
            throw new IllegalArgumentException("postalCode is invalid");
        }

        if (StringUtils.isEmpty(country)) {
            throw new IllegalArgumentException("country must not be empty");
        }

        if (!ObjectUtils.isEmpty(creditLimit) && creditLimit.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("creditLimit is invalid");
        }
    }
}
