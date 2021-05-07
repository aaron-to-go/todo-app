package de.neufische.backend.repository;

import de.neufische.backend.models.AddKanbanTaskDTO;
import de.neufische.backend.models.KanbanTask;
import de.neufische.backend.utils.IDGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class KanbanRepositoryTest {


    @Test
    void addToDo() {
        IDGenerator mockID= Mockito.mock(IDGenerator.class);
        // Given
        when(mockID.generateID()).thenReturn("42");
        KanbanRepository kanbanRepository = new KanbanRepository(mockID);
        AddKanbanTaskDTO newTask = new AddKanbanTaskDTO("test", "OPEN");

        // When
        KanbanTask actual = kanbanRepository.addToDo(newTask);


        // Then
        KanbanTask expected = new KanbanTask("42","test","OPEN");
        assertEquals(actual,expected);
    }


    @Test
    void deleteTask() {
    }

    @Test
    void getDetails() {
    }

    @Test
    void advanceTask() {
    }
}