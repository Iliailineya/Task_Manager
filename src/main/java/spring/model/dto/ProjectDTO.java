package spring.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.util.validation.UniqueProjectName;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    @NotBlank
    @Size(min = 3, message = "size must be at least 3 symbols")
    @UniqueProjectName(message = "Project name is not unique")
    private String name;
    @NotBlank
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}

