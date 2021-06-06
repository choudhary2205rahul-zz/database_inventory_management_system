package com.management.inventory.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectResponse {

    private int projectId;
    private String description;
    private InventoryResponse inventory;
}
