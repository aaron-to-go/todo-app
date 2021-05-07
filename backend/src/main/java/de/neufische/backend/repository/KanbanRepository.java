package de.neufische.backend.repository;

import de.neufische.backend.models.AddKanbanTaskDTO;
import de.neufische.backend.models.KanbanTask;
import de.neufische.backend.utils.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class KanbanRepository {

    private final HashMap<String, KanbanTask> kanbanMap = new HashMap<>();
    private final IDGenerator idGenerator;

    @Autowired
    public KanbanRepository(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public KanbanTask addToDo(AddKanbanTaskDTO newKanbanTask) {

        String id = idGenerator.generateID();
        String description = newKanbanTask.getDescription();
        String status = newKanbanTask.getStatus();

        KanbanTask newTask = new KanbanTask(id,description,status);

        kanbanMap.put(id, newTask);

        return newTask;
    }

    public List<KanbanTask> list() {
        return List.copyOf(kanbanMap.values());
    }

    public void deleteTask(String id) {

        kanbanMap.remove(id);

    }


}
