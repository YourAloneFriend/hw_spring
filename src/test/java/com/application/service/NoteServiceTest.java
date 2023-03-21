package com.application.service;

import com.application.entity.Note;
import com.application.service.serviceImpl.NoteServiceImpl;
import org.junit.jupiter.api.*;

import java.util.UUID;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NoteServiceTest {

    private static NoteService service;

    @BeforeAll
    static void setUp() {
        service = new NoteServiceImpl();
    }


    @Order(1)
    @Test
    void add() {
        service.add(Note.builder().id(1).title("Smth").content("Text").build());
    }


    @Order(2)
    @Test
    void listAll() {
        Assertions.assertEquals(1, service.listAll().size());
    }


    @Order(3)
    @Test
    void getById() {
        Assertions.assertNotNull(service.getById(1));
    }

    @Order(4)
    @Test
    void update() {
        Note note = Note.builder().id(1).title("Updated title").content("Updated context").build();
        service.update(note);
        note = service.getById(1);
        Assertions.assertEquals("Updated title", note.getTitle());
        Assertions.assertEquals("Updated context", note.getContent());
    }

    @Order(5)
    @Test
    void deleteById() {
        service.deleteById(1);
        Assertions.assertNull(service.getById(1));
    }

}