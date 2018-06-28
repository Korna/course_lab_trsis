package com.coma.db.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Record")

public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "exhibit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Record() {
    }

    public Record(Record record) {
        this.author = record.getAuthor();
        this.description = record.getDescription();
        this.date = record.getDate();
    }

    public Record(String title, String description, String date) {
        this.author = title;
        this.description = description;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
