package dev.wess.note_taking_app.repositories;

import dev.wess.note_taking_app.domain.SecureNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecureNoteRepository extends JpaRepository<SecureNote, Long> {
}