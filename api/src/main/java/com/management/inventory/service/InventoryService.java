package com.management.inventory.service;

import com.management.inventory.model.InventoryRequest;
import com.management.inventory.model.InventoryResponse;

import java.util.List;

public interface InventoryService {

    List<InventoryResponse> findAll();

    InventoryResponse findById(int projectId);

    void deleteById(int projectId);

    InventoryResponse saveOrUpdate(InventoryRequest inventoryRequest);
}
