package com.coma.service;

import com.coma.db.model.Record;

public interface ExhibitService {

    Iterable<Record> listAll();

    void delete(Integer id);
    
    Record add(String title, String description, String lifeTime);

    Record add(Record record);
}
