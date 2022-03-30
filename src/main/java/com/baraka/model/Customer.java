package com.baraka.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Transactional
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cust_id")
    private Long id;

    @Column(name = "cust_govn_id", nullable = false, unique = true)
    private String registeredGovernmentId;

    @Column(name = "cust_first_name", nullable = false)
    private String firstName;

    @Column(name = "cust_last_name", nullable = false)
    private String lastName;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "cust_id")
    @Column(name = "cust_beneficiaries")
    private List<Beneficiary> beneficiaries = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "cust_id")
    @Column(name = "cust_accounts", nullable = false)
    private List<AccountDetail> accountDetails = new ArrayList<>();

    @Column(name = "cust_email_id", nullable = false)
    private String emailId;

    @Column(name = "cust_contact_number", nullable = false)
    private String contactNumber;

    @Column(name = "cust_nominee_name")
    private String nomineeName;

    @Column(name = "cust_creation_time")
    @CreationTimestamp
    private LocalDateTime creationTime;

    @Column(name = "cust_lastmodified_time")
    @UpdateTimestamp
    private LocalDateTime lastModifiedTime;
}
