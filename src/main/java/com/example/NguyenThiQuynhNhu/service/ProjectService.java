package com.example.NguyenThiQuynhNhu.service;

import com.example.NguyenThiQuynhNhu.dto.ProjectDTO;
import com.example.NguyenThiQuynhNhu.entity.Project;
import com.example.NguyenThiQuynhNhu.exception.ResourceNotFoundException;
import com.example.NguyenThiQuynhNhu.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    // 1. Lấy tất cả dự án
    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // 2. Lấy 1 dự án theo ID
    public ProjectDTO getProjectById(String id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy dự án với ID: " + id));
        return mapToDTO(project);
    }

    // 3. Tạo mới dự án
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = mapToEntity(projectDTO);
        Project savedProject = projectRepository.save(project);
        return mapToDTO(savedProject); // Trả về DTO cho Frontend
    }

    // 4. Cập nhật dự án
    public ProjectDTO updateProject(String id, ProjectDTO projectDTO) {
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không thể cập nhật. Không tìm thấy dự án với ID: " + id));

        existingProject.setTitle(projectDTO.getTitle());
        existingProject.setRole(projectDTO.getRole());
        existingProject.setDescription(projectDTO.getDescription());
        existingProject.setTechnologies(projectDTO.getTechnologies());
        existingProject.setGithubUrl(projectDTO.getGithubUrl());
        existingProject.setLiveDemoUrl(projectDTO.getLiveDemoUrl());

        Project updatedProject = projectRepository.save(existingProject);
        return mapToDTO(updatedProject);
    }

    // 5. Xóa dự án
    public void deleteProject(String id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không thể xóa. Không tìm thấy dự án với ID: " + id));

        projectRepository.delete(project);
    }

    private ProjectDTO mapToDTO(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setTitle(project.getTitle());
        dto.setRole(project.getRole());
        dto.setDescription(project.getDescription());
        dto.setTechnologies(project.getTechnologies());
        dto.setGithubUrl(project.getGithubUrl());
        dto.setLiveDemoUrl(project.getLiveDemoUrl());
        return dto;
    }

    private Project mapToEntity(ProjectDTO dto) {
        Project project = new Project();
        project.setTitle(dto.getTitle());
        project.setRole(dto.getRole());
        project.setDescription(dto.getDescription());
        project.setTechnologies(dto.getTechnologies());
        project.setGithubUrl(dto.getGithubUrl());
        project.setLiveDemoUrl(dto.getLiveDemoUrl());
        return project;
    }
}