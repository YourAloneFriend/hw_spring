package com.application.service.serviceImpl;

import com.application.entity.Note;
import com.application.repository.NoteRepository;
import com.application.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {


    private final NoteRepository repository;

    @Override
    public List<Note> listAll() {
        return repository.findAll();
    }

    @Override
    public void add(Note note) {
        repository.save(note);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Note note) {
        repository.updateNote(note.getTitle(), note.getContent(), note.getId());
    }

    @Override
    public Note getById(long id) {
        return repository.findById(id).get();
    }
}
