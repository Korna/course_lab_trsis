package com.coma.db.dao;

import com.coma.db.model.Record;
import org.springframework.data.repository.CrudRepository;

public interface ExhibitRepository extends CrudRepository<Record, Integer> {
}
