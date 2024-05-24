package edu.itstep.springbootweb.web.controller;

import edu.itstep.springbootweb.domain.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/v1/users")
@RestController
public class UserController {

    private List<User> users = new ArrayList<>();

    {
        users.addAll(List.of(
                User.builder()
                        .id(UUID.randomUUID().toString())
                        .name("Bob")
                        .build(),
                User.builder()
                        .id(UUID.randomUUID().toString())
                        .name("Ann")
                        .build(),
                User.builder()
                        .id(UUID.randomUUID().toString())
                        .name("Petro")
                        .build()));
    }

    @GetMapping
    public ResponseEntity<List<User>> findALl() {
        return ResponseEntity.ok(
                users
        );
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> findById(
            @PathVariable String userId
    ) {
        Optional<User> user = users.stream()
                .filter(collectionUser -> collectionUser.getId().equals(userId))
                .findFirst();

        if (user.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Not found");

        return ResponseEntity.ok(
                user
        );
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> update(
            @RequestBody User user,
            @PathVariable int userId
    ) {
        System.out.println(user);
        users.set(userId, user);
        return ResponseEntity.ok(users.get(userId));
    }

    // /users
    // /users/{userId}
    // /users/{userId}/subscribers
    // /users/{userId}/subscribers/{subscriberId}

    // /user
    // /users

    // /cars
    // /shops/{id}/category/{id}/price

    // /shops/{id}

    // POST /updateuser GET /getuser

    // PUT /users/{userId}

    // /messages/{id}/resend

    // /health
    // /version
    // /metrics

    // swagger
    //

    /*

{
    users: [
        ...
    ],
    offset: 0,
    total: 12
}

     */

    // limit offset

    // ?fields=id,name,address

    // Authorization: Bearer adasdasd

    // application/x-www-form-urlencoded

    // GET /shops/2/products
    // GET /shops/2/products/31
    // DELETE /shops/2/products/31
    // PUT /shops/2/products/31
    // POST /shops

    // CORS

    // HTTPS

    // 4xx

    // shops/1/waiters/1/addresses/2/country/asdas

    // /posts?tags=js

    // id cannot be longer than 16 characters


    // /users/{id}
    // /users?id=5

    // /videos/WpFqiPF_Kxk
}