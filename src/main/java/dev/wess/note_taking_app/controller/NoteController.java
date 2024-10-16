package dev.wess.note_taking_app.controller;

import dev.wess.note_taking_app.domain.Note;
import dev.wess.note_taking_app.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note createdNote = noteService.createNote(note);
        return new ResponseEntity<>(createdNote, HttpStatus.CREATED);
    }
    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}