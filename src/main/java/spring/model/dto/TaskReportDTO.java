package spring.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskReportDTO {
    private Long taskId;
    private LocalDate completionDate;
    @NotBlank
    private String description;
}
