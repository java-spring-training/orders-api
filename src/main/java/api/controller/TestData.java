package api.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotEmpty;

public class TestData {

    @NotEmpty(message = "name is empty")
    private String name;

    public TestData(String name) {

        this.name = name;
    }

    public TestData() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
