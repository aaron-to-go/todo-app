package de.neufische.backend.repository;

import de.neufische.backend.models.KanbanTask;
import de.neufische.backend.models.KanbanTaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.cache.support.NullValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class KanbanRepositoryTest {

    @Test
    void addTodoAddsAnotherTaskToRepositoryAndGetByIDFindsTaskByID() {
        // GIVEN
        KanbanRepository givenRepository= new KanbanRepository();

        // WHEN
        KanbanTask expectedTask = new KanbanTask("123", "Best Dogo, good boy", "BEST");
        givenRepository.addTodo("123", new KanbanTaskDto("Best Dogo, good boy", "BEST"));

        // THENN
        assertEquals(givenRepository.getById("123"), expectedTask);

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