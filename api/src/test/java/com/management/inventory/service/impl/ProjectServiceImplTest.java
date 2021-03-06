package com.management.inventory.service.impl;

import com.management.inventory.entity.Inventory;
import com.management.inventory.entity.Project;
import com.management.inventory.model.ProjectResponse;
import com.management.inventory.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void FindAll() {
        List<ProjectResponse> all = projectService.findAll();
        assertEquals(0, all.size());
    }

    @Test
    void findById() {
        Inventory inventory = Inventory.builder().id(1).build();
        Optional<Project> byId = Optional.of(Project.builder().projectId(1).description("Test Project").inventory(inventory).build());
        when(projectRepository.findById(1)).thenReturn(byId);
        ProjectResponse response = projectService.findById(1);
        assertEquals(1,response.getProjectId());
    }

}