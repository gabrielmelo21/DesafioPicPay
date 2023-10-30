package com.picpaysimplificado.picpaysimplificado.Domain.Transactions;

import com.picpaysimplificado.picpaysimplificado.Domain.Users.Users;
import jakarta.persistence.*;
import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "transactions")
@Data
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private BigDecimal amount;

    @Column(name = "sender_id")
    @ManyToOne
    private Users sender;

    @Column(name = "receiver_id")
    @ManyToOne
    private Users receiver;

    private LocalDateTime timestamp;



}
