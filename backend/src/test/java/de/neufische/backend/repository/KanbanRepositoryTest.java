package de.neufische.backend.repository;

import de.neufische.backend.models.AddKanbanTaskDTO;
import de.neufische.backend.models.KanbanTask;
import de.neufische.backend.utils.IDGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
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
        IDGenerator mockID= Mockito.mock(IDGenerator.class);
        when(mockID.generateID()).thenReturn("123");
        KanbanRepository givenRepository = new KanbanRepository(mockID);
        givenRepository.addToDo(new AddKanbanTaskDTO("Hund", "OPEN"));

        //WHEN
        KanbanTask advancedTask = new KanbanTask("123", "Hund", "SOLVED");
        KanbanTask actualTask = givenRepository.advanceTask(advancedTask);

        //THEN
        assertThat(actualTask.getStatus(), is("SOLVED"));
    }

    @Test
    void testGetByIdReturnsTaskWithMatchingIdFromRepository() {
        //GIVEN
        IDGenerator mockID= Mockito.mock(IDGenerator.class);
        when(mockID.generateID()).thenReturn("1");
        KanbanRepository givenRepository = new KanbanRepository(mockID);
        AddKanbanTaskDTO searchedTaskDto = new AddKanbanTaskDTO("Hund", "SOLVED");
        KanbanTask searchedTask = new KanbanTask("1","Hund", "SOLVED");
        givenRepository.addToDo(searchedTaskDto);

        // WHEN
        KanbanTask expectedTask = new KanbanTask("1", "Hund", "SOLVED");
        KanbanTask actualTask = givenRepository.advanceTask(searchedTask);

        // THEN
        assertThat(actualTask, is(expectedTask));
    }


    @Test
    void deleteTaskRemovesTaskWithMatchingIdFromRepository() {

        //GIVEN
        IDGenerator mockID= Mockito.mock(IDGenerator.class);
        when(mockID.generateID()).thenReturn("1");
        KanbanRepository givenRepository = new KanbanRepository(mockID);
        givenRepository.addToDo(new AddKanbanTaskDTO("Hund", "SOLVED"));
        givenRepository.addToDo(new AddKanbanTaskDTO("Katze", "OPEN"));

        //WHEN
        String removeById = "1";
        givenRepository.deleteTask(removeById);

        //THEN
        assertThat(givenRepository.getDetails("1"), is(nullValue()));
    }
}