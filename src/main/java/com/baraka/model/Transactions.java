package com.baraka.model;

import com.baraka.enums.CURRENCY;
import com.baraka.enums.TRANSACTION_STATUS;
import com.baraka.enums.TRANSACTION_TYPE;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@Builder
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trans_id", unique = true)
    private Long id;

    @Column(name = "trans_cust_id", nullable = false)
    private Long customerId;

    @Column(name = "trans_receiver_id", nullable = false)
    private String receivedId;

    @Column(name = "trans_curency", nullable = false)
    CURRENCY currency;

    @Column(name = "trans_type", nullable = false)
    private TRANSACTION_TYPE type;

    @Column(name = "trans_status", nullable = false)
    private TRANSACTION_STATUS status;

    @Column(name = "trans_creation_time")
    @CreationTimestamp
    private LocalDateTime creationTime;

    @Column(name = "trans_lastmodified_time")
    @UpdateTimestamp
    private LocalDateTime lastModifiedTime;

    @Column(name = "trans_amount", nullable = false)
    private BigDecimal amount;
}
