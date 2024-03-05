package spring.util.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import spring.repository.ProjectRepository;

public class UniqueProjectNameValidation implements ConstraintValidator<UniqueProjectName, String> {
    private final ProjectRepository projectRepository;

    public UniqueProjectNameValidation(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public boolean isValid(String projectName, ConstraintValidatorContext context) {
        return !projectRepository.existsByProjectName(projectName);
    }
}