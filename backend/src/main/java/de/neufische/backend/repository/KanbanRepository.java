package de.neufische.backend.repository;

import de.neufische.backend.models.KanbanTask;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class KanbanRepository {

    private final HashMap<String, KanbanTask> kanbanMap = new HashMap<>();

    public KanbanTask addToDo(KanbanTask newKanbanTask) {
        kanbanMap.put(newKanbanTask.getId(), newKanbanTask);
        return newKanbanTask;
    }


}
