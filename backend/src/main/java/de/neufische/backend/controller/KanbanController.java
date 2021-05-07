package de.neufische.backend.controller;

import de.neufische.backend.models.KanbanTask;
import org.springframework.web.bind.annotation.PostMapping;

public class KanbanController {

    @PostMapping
    public KanbanTask addTodo(KanbanTask newTask){

    }
}
