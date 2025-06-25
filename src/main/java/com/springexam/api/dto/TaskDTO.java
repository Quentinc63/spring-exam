package com.springexam.api.dto;
import com.springexam.api.model.TaskStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private Long id;
    private String title;
    private Long userId;
    private Long projectId;
    private TaskStatus status;
    
}
