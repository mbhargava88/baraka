package com.baraka.model;

import com.baraka.enums.ACCOUNT_TYPE;
import com.baraka.enums.CURRENCY;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id", unique = true)
    private Long accountId;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "account_id")
    @Column(name = "transactions")
    private List<Transactions> transaction = new ArrayList<>();

    @Column(name = "account_type", nullable = false)
    ACCOUNT_TYPE accountType;

    @Column(name = "account_currency", nullable = false)
    CURRENCY currency;

    @Column(name = "account_available_balance", nullable = false)
    BigDecimal availableBalance;

    @Column(name = "account_active")
    boolean active;

    @Column(name = "account_creation_time")
    @CreationTimestamp
    private LocalDateTime creationTime;

    @Column(name = "account_lastmodified_time")
    @UpdateTimestamp
    private LocalDateTime lastModifiedTime;
}
