package dev.pdhau.ordermanagementapi.domain.value.object;

import org.glassfish.jersey.internal.guava.Preconditions;

import lombok.Getter;

@Getter
public class OrderNumberObject {

    private int numberObject;

    public OrderNumberObject(int numberObject) {
        Preconditions.checkArgument(numberObject > 0, "id must be > 0");
        this.numberObject = numberObject;
    }
}
