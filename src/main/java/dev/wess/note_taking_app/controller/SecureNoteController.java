package dev.wess.note_taking_app.controller;

import dev.wess.note_taking_app.domain.SecureNote;
import dev.wess.note_taking_app.service.SecureNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/secure-note")
public class SecureNoteController {
    @Autowired
    private SecureNoteService secureNoteService;

    @PostMapping
    public ResponseEntity<SecureNote> createSecureNote(@RequestBody SecureNote note, @RequestParam String password) {
        SecureNote createdNote = secureNoteService.createSecureNote(note, password);
        return new ResponseEntity<>(createdNote, HttpStatus.OK);
    }

    @PostMapping("/validate")
    public ResponseEntity<Boolean> validatePassword(@RequestParam Long noteId, @RequestParam String password) throws Exception {
        SecureNote note = secureNoteService.getNoteById(noteId);
        boolean isValid = secureNoteService.validatePassword(note, password);
        return new ResponseEntity<>(isValid, HttpStatus.OK);
    }

}
