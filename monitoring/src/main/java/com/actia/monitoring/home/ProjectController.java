package com.actia.monitoring.home;

import com.Actia.pfe.home.model.*;
import com.Actia.pfe.home.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<MessageResponse> createProject(@Valid @RequestBody Project projectRequest) {
        Project project = projectService.addProject(projectRequest);
        String message = String.format("Project '%s' created successfully", project.getName());
        return ResponseEntity.ok(new MessageResponse(message));
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        List<ProjectResponse> projectResponses = projects.stream()
                .map(project -> new ProjectResponse(project.getId(), project.getName()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(projectResponses);
    }
}

