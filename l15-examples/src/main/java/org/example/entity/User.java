package org.example.entity;

import lombok.*;


@RequiredArgsConstructor
@ToString(exclude = {"password"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private int id;

    @Setter
    @EqualsAndHashCode.Include
    private String name;
    @EqualsAndHashCode.Include
    private final int age;

    private String password;

    public User(
            int id,
            @NonNull String name,
            int age,
            @NonNull String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.password = password;
    }
}
