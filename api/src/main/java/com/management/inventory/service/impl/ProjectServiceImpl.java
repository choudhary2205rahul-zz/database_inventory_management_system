package com.management.inventory.service.impl;

import com.management.inventory.entity.Project;
import com.management.inventory.model.ProjectRequest;
import com.management.inventory.model.ProjectResponse;
import com.management.inventory.repository.ProjectRepository;
import com.management.inventory.service.ProjectService;
import com.management.inventory.util.InventoryConversion;
import com.management.inventory.util.TestConnectivity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public List<ProjectResponse> findAll() {
        List<Project> all = projectRepository.findAll();
        return all.stream().map(ir -> InventoryConversion.convertToProjectResponse(ir))
                .collect(Collectors.toList());
    }

    @Override
    public ProjectResponse findById(int projectId) {
        Optional<Project> byId = projectRepository.findById(projectId);
        if (byId.isPresent()) {
            ProjectResponse projectResponse = InventoryConversion.convertToProjectResponse(byId.get());
            projectResponse.getInventory().setPassword(null);
            return projectResponse;
        }
        return null;
    }

    @Override
    public ProjectResponse findByIdAdmin(int projectId) {
        Optional<Project> byId = projectRepository.findById(projectId);
        if (byId.isPresent()) {
            ProjectResponse projectResponse = InventoryConversion.convertToProjectResponse(byId.get());
            return projectResponse;
        }
        return null;
    }


    @Override
    public void deleteById(int projectId) {
        // find inventory
        Optional<Project> byId = projectRepository.findById(projectId);
        if (byId.isPresent()) {
            // remove inventory
            projectRepository.deleteById(projectId);
        }
    }

    @Override
    public ProjectResponse saveOrUpdate(ProjectRequest inventoryRequest) {

        Project inventory = InventoryConversion.convertToProject(inventoryRequest);

        Project save = projectRepository.save(inventory);

        ProjectResponse projectResponse = InventoryConversion.convertToProjectResponse(save);

        return projectResponse;
    }

    @Override
    public boolean testConnectivity(ProjectRequest projectRequest) {
        try {
            boolean result = TestConnectivity.checkConnectivity(projectRequest);
            return result;
        } catch (Exception e) {
            log.error("Error while connectivity test: " + e);
        }
        return false;
    }
}
