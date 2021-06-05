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
    @Column(name = "project_id")
    private int projectId;

    @Column(name = "project_description")
    private String description;

    @Column(name = "db_type")
    private String dbType;

    @Column(name = "db_name")
    private String dbName;

    @Column(name = "host_name")
    private String hostName;

    @Column(name = "port")
    private int port;

    @Column(name = "password")
    private String password;
}
