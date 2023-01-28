package com.projects.springdatajpapostgresql.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_address_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_address_id",strategy =GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(length = 500)
    private String address;

    @Enumerated
    private AddressType addressType;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "user_address_id")
    private User user;
    public enum AddressType{
        HOME_ADDRESS,
        BUSINESS_ADDRESS,
        OTHER
    }
}
