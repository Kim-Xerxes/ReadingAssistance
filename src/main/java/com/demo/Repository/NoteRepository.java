package com.demo.Repository;

import com.demo.Entity.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository<Note,Integer> {
    boolean existsByUid(Integer uid);
    Iterable<Note> findNotesByUid(Integer uid);
    Iterable<Note> findNotesByUidAndISBN(Integer uid, String ISBN);
}
