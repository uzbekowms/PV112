//package edu.itstep.springdatajpa.domain.model.example.onetoone;
//
//import jakarta.persistence.*;
//import lombok.*;
//import org.hibernate.annotations.Collate;
//
//@Table(name = "messages")
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Builder
//public class Message {
//
//    @Id
//    @Column(name = "message_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "attachment_id", referencedColumnName = "id")
//    private Attachment attachment;
//}
