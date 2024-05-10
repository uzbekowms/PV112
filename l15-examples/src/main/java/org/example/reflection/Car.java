package org.example.reflection;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@TestAnnotation
@Getter
public class Car {

    @TestAnnotation
    private int horsepower;
    private final String serialNumber;
    public String carName;

    public void printSerialNumber() {
        System.out.println(this.serialNumber);
    }
}
