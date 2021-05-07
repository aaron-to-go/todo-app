package de.neufische.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class KanbanControllerTest {

    @LocalServerPort
    private int port;



    @Test
    void addTodo() {
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