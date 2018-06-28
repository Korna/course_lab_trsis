package com.coma.db.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @Column(name = "category_id")
    private Integer id;

    @Column(name = "author")
    private String author;

    @OneToMany(targetEntity = Record.class, mappedBy = "category" , fetch = FetchType.LAZY)
    private List<Record> recordList;

    public Category() {
    }

    public Category(Integer id, String author) {
        this.id = id;
        this.author = author;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }
}
