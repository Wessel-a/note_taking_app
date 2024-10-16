package dev.wess.note_taking_app.service;

import dev.wess.note_taking_app.domain.SecureNote;
import dev.wess.note_taking_app.repositories.SecureNoteRepository;
import dev.wess.note_taking_app.security.Crypto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecureNoteService {
    @Autowired
    private SecureNoteRepository secureNoteRepository;

    public SecureNote createSecureNote(SecureNote note, String password) {
        note.setPasswordHash(Crypto.hash(password));
        return secureNoteRepository.save(note);
    }

    public boolean validatePassword(SecureNote note, String password) {
        return note.getPasswordHash().equals(Crypto.hash(password));
    }

    public SecureNote getNoteById(Long noteId) throws Exception {
            return secureNoteRepository.findById(noteId)
                    .orElseThrow(() -> new Exception("SecureNote not found with id: " + noteId));

    }
}
