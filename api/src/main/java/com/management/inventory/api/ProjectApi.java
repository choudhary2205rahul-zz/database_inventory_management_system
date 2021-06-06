package com.management.inventory.api;

import com.management.inventory.model.ProjectRequest;
import com.management.inventory.model.ProjectResponse;
import com.management.inventory.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/projects")
public class ProjectApi {

    private ProjectService projectService;

    public ProjectApi(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> saveOrUpdate(@RequestBody ProjectRequest projectRequest) {
        ProjectResponse inventoryRequestSavedOrUpdate = projectService.saveOrUpdate(projectRequest);
        return new ResponseEntity<>(inventoryRequestSavedOrUpdate, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> findAll() {
        List<ProjectResponse> all = projectService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectResponse> findById(@PathVariable int projectId) {
        ProjectResponse byId = projectService.findById(projectId);
        return new ResponseEntity<>(byId,HttpStatus.OK);
    }

    @GetMapping("/admin/{projectId}")
    public ResponseEntity<ProjectResponse> findByIdAdmin(@PathVariable int projectId) {
        ProjectResponse byId = projectService.findByIdAdmin(projectId);
        return new ResponseEntity<>(byId,HttpStatus.OK);
    }

    @DeleteMapping("/{projectId}")
    public void deleteById(@PathVariable int projectId) {
        projectService.deleteById(projectId);
    }

    @PostMapping("/connectivity")
    public ResponseEntity<Boolean> testConnectivity(@RequestBody ProjectRequest projectRequest) {
        boolean result = projectService.testConnectivity(projectRequest);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
