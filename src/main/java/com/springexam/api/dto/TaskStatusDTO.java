package com.springexam.api.dto;


import com.springexam.api.model.TaskStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskStatusDTO {
    @NotNull
    private TaskStatus status;
}
