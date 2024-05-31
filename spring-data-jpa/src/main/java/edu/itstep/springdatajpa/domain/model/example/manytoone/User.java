//package edu.itstep.springdatajpa.domain.model.example.manytoone;
//
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.List;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Builder
//@Entity
//@Table(name = "otm_users")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private String name;
//
//    @OneToMany(mappedBy = "sender")
//    private List<Message> messages;
//}
