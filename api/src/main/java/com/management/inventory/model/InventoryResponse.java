package com.management.inventory.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryResponse {

    private int id;
    private String dbType;
    private String dbName;
    private String hostname;
    private int port;
    private String username;
    private String password;
}
