package de.neufische.backend.service;

import de.neufische.backend.models.AddKanbanTaskDTO;
import de.neufische.backend.models.KanbanTask;
import de.neufische.backend.repository.KanbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KanbanService {

    private final KanbanRepository kanbanRepository;

    @Autowired
    public KanbanService(KanbanRepository kanbanRepository) {
        this.kanbanRepository = kanbanRepository;
    }

    public KanbanTask addKanbanTask(AddKanbanTaskDTO kanbanTaskDTO) {
        KanbanTask newKanbanTask = kanbanRepository.addToDo(kanbanTaskDTO);
        return newKanbanTask;
    }

    public void deleteTask(String id) {

        kanbanRepository.deleteTask(id);

    }
    //addTodo PostMapping

//    @GetMapping


    //deleteTodo

    //advanceTodo PutMapping
}
