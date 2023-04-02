package com.application.service.serviceImpl;

import com.application.entity.Note;
import com.application.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteServiceImpl implements NoteService {

    private Map<Long, Note> notes = new HashMap<>();

    @Override
    public List<Note> listAll() {
        List<Note> noteList = notes.values().stream().toList();
        return noteList;
    }

    @Override
    public Note add(Note note) {
        notes.put(note.getId(), note);
        return note;
    }

    @Override
    public void deleteById(long id) {
        notes.remove(id);
    }

    @Override
    public void update(Note note) {
        notes.replace(note.getId(), note);
    }

    @Override
    public Note getById(long id) {
        return notes.get(id);
    }
}
