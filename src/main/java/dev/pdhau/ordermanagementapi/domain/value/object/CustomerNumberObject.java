package dev.pdhau.ordermanagementapi.domain.value.object;

import org.glassfish.jersey.internal.guava.Preconditions;

import lombok.Getter;

@Getter
public class CustomerNumberObject {

    private int numberObject;

    public CustomerNumberObject(int numberObject) {
        Preconditions.checkArgument(numberObject > 0, "id must be > 0");
        this.numberObject = numberObject;
    }
}
