package com.baraka.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Beneficiary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "beneficiary_id", unique = true)
    private Long id;

    @Column(name = "beneficiary_first_name", nullable = false)
    private String firstName;

    @Column(name = "beneficiary_last_name", nullable = false)
    private String lastName;

    @Column(name = "beneficiary_email_id", nullable = false)
    private String emailId;

    @Column(name = "beneficiary_contact_number", nullable = false)
    private String contactNumber;

    @Column(name = "beneficiary_creation_time")
    @CreationTimestamp
    private LocalDateTime creationTime;

    @Column(name = "beneficiary_lastmodified_time")
    @UpdateTimestamp
    private LocalDateTime lastModifiedTime;
}
