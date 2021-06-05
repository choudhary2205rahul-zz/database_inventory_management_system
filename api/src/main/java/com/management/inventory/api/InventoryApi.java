package com.management.inventory.api;

import com.management.inventory.model.InventoryRequest;
import com.management.inventory.model.InventoryResponse;
import com.management.inventory.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryApi {

    private InventoryService inventoryService;

    public InventoryApi(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public InventoryResponse saveOrUpdate(@RequestBody InventoryRequest inventoryRequest) {
        InventoryResponse inventoryRequestSavedOrUpdate = inventoryService.saveOrUpdate(inventoryRequest);
        return inventoryRequestSavedOrUpdate;
    }

    @GetMapping
    public List<InventoryResponse> findAll() {
        List<InventoryResponse> all = inventoryService.findAll();
        return all;
    }

    @GetMapping("/{projectId}")
    public InventoryResponse findById(@PathVariable int projectId) {
        InventoryResponse byId = inventoryService.findById(projectId);
        return byId;
    }

    @DeleteMapping("/{projectId}")
    public void deleteById(@PathVariable int projectId) {
        inventoryService.deleteById(projectId);
    }
}
