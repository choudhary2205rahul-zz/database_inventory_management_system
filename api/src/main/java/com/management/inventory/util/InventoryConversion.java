package com.management.inventory.util;

import com.management.inventory.entity.Inventory;
import com.management.inventory.entity.Project;
import com.management.inventory.model.InventoryResponse;
import com.management.inventory.model.ProjectRequest;
import com.management.inventory.model.ProjectResponse;

public class InventoryConversion {

    public static ProjectResponse convertToProjectResponse(Project ir) {

        InventoryResponse inventoryResponse = InventoryResponse.builder()
                .id(ir.getInventory().getId())
                .username(ir.getInventory().getUsername())
                .password(ir.getInventory().getPassword())
                .hostname(ir.getInventory().getHostname())
                .port(ir.getInventory().getPort())
                .dbName(ir.getInventory().getDbName())
                .dbType(ir.getInventory().getDbType())
                .build();

        return ProjectResponse.builder()
                .projectId(ir.getProjectId())
                .description(ir.getDescription())
                .inventory(inventoryResponse)
                .build();
    }

    public static Project convertToProject(ProjectRequest request) {

        Inventory inventory = Inventory.builder()
                .id(request.getInventory().getId())
                .username(request.getInventory().getUsername())
                .password(request.getInventory().getPassword())
                .hostname(request.getInventory().getHostname())
                .port(request.getInventory().getPort())
                .dbName(request.getInventory().getDbName())
                .dbType(request.getInventory().getDbType())
                .build();

        return Project.builder()
                .projectId(request.getProjectId())
                .description(request.getDescription())
                .inventory(inventory)
                .build();
    }
}
