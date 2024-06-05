//package edu.itstep.springdatajpa.domain.model.example.onetomany;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Table(name = "otm_messages")
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
//
//    @ManyToOne
//    @JoinColumn(name = "sender_id", referencedColumnName = "id")
//    private User sender;
//}
