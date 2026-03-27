package com.example.NguyenThiQuynhNhu;

import com.example.NguyenThiQuynhNhu.entity.Project;
import com.example.NguyenThiQuynhNhu.repository.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(ProjectRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                Project project1 = new Project();
                project1.setTitle("ViSmart - Quản lý tài chính cá nhân");
                project1.setRole("Backend Developer");
                project1.setDescription("Ứng dụng giúp người dùng quản lý thu chi, lập ngân sách hiệu quả.");
                project1.setTechnologies(Arrays.asList("Spring Boot", "React.js", "MongoDB"));
                project1.setGithubUrl("https://github.com/yourusername/vismart");
                project1.setLiveDemoUrl("https://vismart-demo.com");

                Project project2 = new Project();
                project2.setTitle("Hệ thống Quản lý công việc nhóm");
                project2.setRole("Fullstack Developer");
                project2.setDescription("Xây dựng hệ thống quản lý task dựa trên phương pháp Agile/Scrum.");
                project2.setTechnologies(Arrays.asList("Java", "Spring Boot", "MySQL", "Trello API"));
                project2.setGithubUrl("https://github.com/yourusername/task-manager");

                repository.saveAll(Arrays.asList(project1, project2));
                System.out.println("Khởi tạo dữ liệu thành công!");
            } else {
                System.out.println("Database đã có dữ liệu, bỏ qua bước khởi tạo.");
            }
        };
    }
}