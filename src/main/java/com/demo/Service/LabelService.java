package com.demo.Service;

import com.demo.Entity.Label;
import com.demo.Repository.LabelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class LabelService {
    private final LabelRepository repository;

    public boolean add(Label label){
        repository.save(label);
        return true;
    }

    public Iterable<Label> findLabelsByUid(Integer uid){
        return repository.findLabelsByUid(uid);
    }
}
