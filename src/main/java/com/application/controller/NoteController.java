package com.application.controller;

import com.application.entity.Note;
import com.application.error.Error;
import com.application.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    NoteService noteService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getNote(){
        ModelAndView mv = new ModelAndView("note");
        noteService.add(Note.builder().id(1).title("smth").content("text").build());
        return mv;
    }

    @GetMapping(value = "/list")
    public ModelAndView getNotes(){
        ModelAndView mv = new ModelAndView("note/note_list");
        List<Note> notes = noteService.listAll();
        mv.addObject("notes", notes);
        return mv;
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteNote(@PathVariable Long id){
        System.out.println(id);
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editNote(@PathVariable Long id, @RequestParam(name = "error", defaultValue = "NO_ERROR") Error error){
        ModelAndView mv = new ModelAndView("note/note_edit");
        Note note = noteService.getById(id);
        mv.addObject("note", note);
        if(error != Error.NO_ERROR) {
            mv.addObject("error", error.getText());
        }

        return mv;
    }

    @PostMapping(value = "/edit/{id}")
    public String doEditNote(@PathVariable Long id, @ModelAttribute Note note){
        Note noteTemp = noteService.getById(id);

        if(note.getContent() != null) {
            if (note.getContent().length() == 0)
                return String.format("redirect:/note/edit/%d?error=%s", id, Error.ERROR_CONTENT);
            else
                noteTemp.setContent(note.getContent());
        }

        if(note.getTitle() != null) {
            if (note.getTitle().length() == 0)
                return String.format("redirect:/note/edit/%d?error=%s", id, Error.ERROR_TITLE);
            else
                noteTemp.setTitle(note.getTitle());
        }

        noteService.update(note);
        return "redirect:/note/list";
    }

}
