package com.management.inventory.service;

import com.management.inventory.model.ProjectRequest;
import com.management.inventory.model.ProjectResponse;

import java.util.List;

public interface ProjectService {

    List<ProjectResponse> findAll();

    ProjectResponse findById(int projectId);

    void deleteById(int projectId);

    ProjectResponse saveOrUpdate(ProjectRequest inventoryRequest);

    ProjectResponse findByIdAdmin(int projectId);

    boolean testConnectivity(ProjectRequest projectRequest);
}
