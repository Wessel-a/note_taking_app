package dev.wess.note_taking_app;

import dev.wess.note_taking_app.domain.Note;
import dev.wess.note_taking_app.domain.SecureNote;
import dev.wess.note_taking_app.repositories.NoteRepository;
import dev.wess.note_taking_app.repositories.SecureNoteRepository;
import dev.wess.note_taking_app.security.Crypto;
import dev.wess.note_taking_app.service.SecureNoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NoteTakingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoteTakingAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(NoteRepository noteRepository, SecureNoteRepository secureNoteRepository, SecureNoteService secureNoteService) {
        return args -> {
            Note note1 = new Note();
            note1.setText("--> Basic note");
            noteRepository.save(note1);

            SecureNote secureNote = new SecureNote();
            secureNote.setText("--> Secure note");
            String password = "secret pass";
            secureNote.setPasswordHash(Crypto.hash(password));
            secureNoteRepository.save(secureNote);

            System.out.println("Notes:");
            noteRepository.findAll().forEach(note -> System.out.println(note.getText()));

            System.out.println("Secure Notes:");
            secureNoteRepository.findAll().forEach(note -> System.out.println(note.getText() + " --> PasswordHash: " + note.getPasswordHash()));


            boolean isValid = secureNoteService.validatePassword(secureNote, password);
            System.out.println("Password validation secure note --> " + isValid);

            boolean isInvalid = secureNoteService.validatePassword(secureNote, "wrong-password");
            System.out.println("Password validation secure note (wrong) --> " + isInvalid);
        };
    }
}
