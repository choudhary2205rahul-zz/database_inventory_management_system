package com.management.inventory.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryResponse {

    private int projectId;
    private String description;
    private String dbType;
    private String dbName;
    private String hostName;
    private int port;
}
