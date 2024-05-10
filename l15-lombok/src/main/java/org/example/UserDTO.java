package org.example;

public record UserDTO(int id, String name) {}


class UserDTOClass {
    private final int id;
    private final String name;
    private final int age;

    public UserDTOClass(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void test() {
        System.out.println(this.age);
    }
}