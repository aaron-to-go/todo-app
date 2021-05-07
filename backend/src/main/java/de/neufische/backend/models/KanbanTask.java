package de.neufische.backend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// @Validation
public class KanbanTask {

    private String id;
    private String description;
    private String status;

    }

