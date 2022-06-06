package com.demo.Service;
import com.demo.Entity.Note;
import com.demo.Repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository repository;

    public boolean existsByNid(Integer nid) { return repository.existsById(nid); }
    public boolean existsByUid(Integer uid){
        return repository.existsByUid(uid);
    }

    public Iterable<Note> findNotesByUid(Integer uid){
        return repository.findNotesByUid(uid);
    }

    public Iterable<Note> findNotesByUidAndISBN(Integer uid, String ISBN){
        return repository.findNotesByUidAndISBN(uid, ISBN);
    }

    public boolean update(Note note){
        if(repository.existsById(note.getNid())){
            repository.save(note);
            return true;
        }
        return false;
    }

    public boolean deleteNoteByNid(Integer nid){
        if(repository.existsById(nid)){
            repository.deleteById(nid);
            return true;
        }
        return false;
    }

    public boolean insert(Note note){
        repository.save(note);
        return true;
    }
}
