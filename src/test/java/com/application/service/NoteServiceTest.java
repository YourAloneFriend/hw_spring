package com.application.service;

import com.application.GoItSpringHwApplication;
import com.application.entity.Note;
import com.application.repository.NoteRepository;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GoItSpringHwApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=validate"
})
class NoteServiceTest {


    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NoteService service;

    @Order(1)
    @Test
    void add() {
        Note note = new Note();
        note.setId(0);
        note.setTitle("Title");
        note.setContent("Context");
        service.add(note);
    }


    @Order(2)
    @Test
    void listAll() {
        Assertions.assertNotNull(service.listAll());
    }


    @Order(3)
    @Test
    void getById() {
        Assertions.assertNotNull(service.getById(0));
    }

    @Order(4)
    @Test
    void update() {
        Note note = new Note();
        note.setId(0);
        note.setTitle("Update Title");
        note.setContent("Update Context");
        service.update(note);
        note = service.getById(0);
        Assertions.assertEquals("Update Title", note.getTitle());
        Assertions.assertEquals("Update Context", note.getContent());
    }

    @Order(5)
    @Test
    void deleteById() {
        service.deleteById(0);
        Assertions.assertThrows(NoSuchElementException.class, () -> service.getById(0));
    }

}