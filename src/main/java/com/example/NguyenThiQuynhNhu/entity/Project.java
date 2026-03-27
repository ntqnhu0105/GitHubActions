package com.example.NguyenThiQuynhNhu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    private String id;
    private String title;
    private String role;
    private String description;
    private List<String> technologies;
    private String githubUrl;
    private String liveDemoUrl;
}