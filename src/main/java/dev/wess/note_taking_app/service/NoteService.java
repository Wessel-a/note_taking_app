package dev.wess.note_taking_app.service;

import dev.wess.note_taking_app.domain.Note;
import dev.wess.note_taking_app.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> updateNote(Long id, Note newNoteData) {
        return noteRepository.findById(id)
                .map(note -> {
                    note.setText(newNoteData.getText());
                    note.setImages(newNoteData.getImages());
                    note.setSketches(newNoteData.getSketches());
                    return noteRepository.save(note);
                });
    }
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}

