package com.management.inventory.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "db_type")
    private String dbType;

    @Column(name= "db_name")
    private String dbName;

    @Column(name= "db_host")
    private String hostname;

    @Column(name= "db_port")
    private int port;

    @Column(name= "db_username")
    private String username;

    @Column(name= "db_password")
    private String password;

    @OneToOne(mappedBy = "inventory")
    private Project project;

}
