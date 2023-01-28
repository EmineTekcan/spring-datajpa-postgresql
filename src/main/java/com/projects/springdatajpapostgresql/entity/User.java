package com.projects.springdatajpapostgresql.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
@Component
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @Id
    @SequenceGenerator(name = "seq_user_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_user_id",strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    private String surname;

    @OneToMany
    @JoinColumn(name = "user_address_id")

    private List<Address> addresses;
}
