package de.neufische.backend.controller;

import de.neufische.backend.models.AddKanbanTaskDTO;
import de.neufische.backend.models.KanbanTask;
import de.neufische.backend.service.KanbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class KanbanController {

    private final KanbanService kanbanService;

    @Autowired
    public KanbanController(KanbanService kanbanService) {
        this.kanbanService = kanbanService;
    }

    @PostMapping("todo")
    public KanbanTask addTodo(@RequestBody AddKanbanTaskDTO newKanbanTask){

        KanbanTask newTask = kanbanService.addKanbanTask(newKanbanTask);

        return newTask;

    }

//    @PutMapping()



}
