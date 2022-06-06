package com.demo.Repository;

import com.demo.Entity.Label;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends CrudRepository<Label, Integer> {
    Iterable<Label> findLabelsByUid(Integer uid);
}
