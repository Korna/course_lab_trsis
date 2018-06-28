package com.coma.service;


import com.coma.db.dao.ExhibitRepository;
import com.coma.db.model.Record;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExhibitServiceImpl implements ExhibitService {

    private final static Logger log = Logger.getLogger(ExhibitServiceImpl.class);

    @Autowired
    private ExhibitRepository exhibitRepository;

    @Override
    public Iterable<Record> listAll() {
        return exhibitRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        exhibitRepository.delete(id);
    }

    @Override
    public Record add(String author, String description, String lifeTime) {
        System.out.print("ADDED");
        return exhibitRepository.save(new Record(author, description, lifeTime));
    }

    @Override
    public Record add(Record record) {
        return exhibitRepository.save(new Record(record));
    }
}
