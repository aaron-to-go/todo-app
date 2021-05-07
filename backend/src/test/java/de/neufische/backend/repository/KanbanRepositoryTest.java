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
    void advanceTodoUpdatesTheStatusOfTaskWithSameIdInRepository() {

        //GIVEN
        KanbanRepository givenRepository = new KanbanRepository();
        givenRepository.addTodo("123", new KanbanTaskDto("Hund", "OPEN"));

        //WHEN
        KanbanTask advancedTask = new KanbanTask("123", "Hund", "SOLVED");
        givenRepository.advanceTodo(advancedTask);

        //THEN
        assertThat(givenRepository.getById("123").getStatus(), is("SOLVED"));
    }

    @Test
    void testGetByIdReturnsTaskWithMatchingIdFromRepository() {
        //GIVEN
        KanbanRepository kanbanRepository = new KanbanRepository();
        KanbanTaskDto searchedTaskDto = new KanbanTaskDto("Hund", "SOLVED");
        KanbanTask searchedTask = new KanbanTask("1","Hund", "SOLVED");
        kanbanRepository.addTodo("1", searchedTaskDto);

        // WHEN
        KanbanTask expectedTask = new KanbanTask("1", "Hund", "SOLVED");
        KanbanTask actualTask = kanbanRepository.advanceTodo(searchedTask);

        // THEN
        assertThat(actualTask, is(expectedTask));
    }


    @Test
    void deleteTaskRemovesTaskWithMatchingIdFromRepository() {

        //GIVEN
        KanbanRepository kanbanRepository = new KanbanRepository();
        kanbanRepository.addTodo("1", new KanbanTaskDto("Hund", "SOLVED"));
        kanbanRepository.addTodo("2", new KanbanTaskDto("Katze", "OPEN"));

        //WHEN
        String removeById = "1";
        kanbanRepository.deleteTask(removeById);

        //THEN
        assertThat(kanbanRepository.getById("1"), is(nullValue()));
    }
}