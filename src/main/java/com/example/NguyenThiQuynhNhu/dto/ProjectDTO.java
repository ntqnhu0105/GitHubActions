package com.example.NguyenThiQuynhNhu.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Data
public class ProjectDTO {
    private String id;

    @NotBlank(message = "Tên dự án không được để trống (VD: ViSmart, Task Manager...)")
    @Size(min = 3, max = 100, message = "Tên dự án phải từ 3 đến 100 ký tự")
    private String title;

    @NotBlank(message = "Vai trò trong dự án không được để trống")
    private String role;

    @NotBlank(message = "Mô tả dự án không được để trống")
    private String description;

    @NotEmpty(message = "Phải liệt kê ít nhất 1 công nghệ sử dụng")
    private List<String> technologies;

    private String githubUrl;
    private String liveDemoUrl;
}