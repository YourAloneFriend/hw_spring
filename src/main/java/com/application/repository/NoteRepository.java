package com.application.repository;

import com.application.entity.Note;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {

    @Override
    @Query(value = "SELECT * FROM note;", nativeQuery = true)
    List<Note> findAll();


    @Transactional
    @Modifying
    @Query(value = "DELETE note WHERE id=:id", nativeQuery = true)
    void deleteById(long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE note SET title = :title, content = :content WHERE id = :id", nativeQuery = true)
    void updateNote(String title, String content, long id);
}
