package spring.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.model.enam.Priority;
import spring.model.enam.Status;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private Status status;
    private Priority priority;
    private LocalDate createdDate;
    private LocalDate dueDate;
    private Long projectId;
}
