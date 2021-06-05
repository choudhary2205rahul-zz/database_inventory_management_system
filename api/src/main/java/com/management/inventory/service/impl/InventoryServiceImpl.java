package com.management.inventory.service.impl;

import com.management.inventory.entity.Inventory;
import com.management.inventory.model.InventoryRequest;
import com.management.inventory.model.InventoryResponse;
import com.management.inventory.repository.InventoryRepository;
import com.management.inventory.service.InventoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {

    private InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<InventoryResponse> findAll() {
        List<Inventory> all = inventoryRepository.findAll();
        return all.stream().map(ir -> InventoryResponse.builder()
                .projectId(ir.getProjectId())
                .dbName(ir.getDbName())
                .dbType(ir.getDbType())
                .hostName(ir.getHostName())
                .port(ir.getPort())
                .description(ir.getDescription())
                .build()).collect(Collectors.toList());
    }

    @Override
    public InventoryResponse findById(int projectId) {
        Optional<Inventory> byId = inventoryRepository.findById(projectId);
        if (byId.isPresent()) {
            InventoryResponse inventoryResponse = new InventoryResponse();
            inventoryResponse.setProjectId(byId.get().getProjectId());
            inventoryResponse.setDbName(byId.get().getDbName());
            inventoryResponse.setDbType(byId.get().getDbType());
            inventoryResponse.setHostName(byId.get().getHostName());
            inventoryResponse.setPort(byId.get().getPort());
            return inventoryResponse;
        }
        return null;
    }

    @Override
    public void deleteById(int projectId) {
        inventoryRepository.deleteById(projectId);
    }

    @Override
    public InventoryResponse saveOrUpdate(InventoryRequest inventoryRequest) {
        Inventory inventory = new Inventory();
        inventory.setProjectId(inventoryRequest.getProjectId());
        inventory.setDbName(inventoryRequest.getDbName());
        inventory.setDbType(inventoryRequest.getDbType());
        inventory.setHostName(inventoryRequest.getHostName());
        inventory.setPort(inventoryRequest.getPort());
        inventory.setPassword(inventoryRequest.getPassword());

        Inventory save = inventoryRepository.save(inventory);

        InventoryResponse inventoryResponse = new InventoryResponse();
        inventoryResponse.setProjectId(save.getProjectId());
        inventoryResponse.setDbName(save.getDbName());
        inventoryResponse.setDbType(save.getDbType());
        inventoryResponse.setHostName(save.getHostName());
        inventoryResponse.setPort(save.getPort());

        return inventoryResponse;
    }
}
