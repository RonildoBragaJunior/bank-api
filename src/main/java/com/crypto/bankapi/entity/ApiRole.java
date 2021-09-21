package com.crypto.bankapi.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiRole {

    @Id
    @SequenceGenerator(name="api_role_sequence", sequenceName = "api_role_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "api_role_sequence")
    private Long id;
    private String name;
}
