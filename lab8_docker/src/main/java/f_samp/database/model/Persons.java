package f_samp.database.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import f_samp.database.model.Position;
import javax.persistence.*;

@Entity
@Table(name="Persons")

public class Persons implements Serializable{

    public Persons(){}

    public Persons(String surname,String name, String patronymic,String passport, Position position_id) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.person_position_id=position_id;
        this.passport = passport;

    }

    public Persons(Integer id,String surname, String name, String patronymic,String passport,Position position_id) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.passport = passport;
        this.person_position_id=position_id;

    }

    @Id
    @Column(name="person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public void setId(Integer id) {this.id=id;}

    public Integer getId() {return id;}


    @Column(name="person_surname")
    private String surname;

    public void setSurname(String surname) {this.surname=surname;}

    public String getSurname() {return surname;}

    @Column(name="person_name")
    private String name;

    public void setName(String name) {this.name=name;}

    public String getName() {return name;}


    @Column(name="person_patronymic")
    private String patronymic;

    public void setPatronymic(String patronymic) {this.patronymic=patronymic;}

    public String getPatronymic() {return patronymic;}

    @Column(name="person_passport")
    private String passport;

    public void setPassport(String passport) {this.passport=passport;}

    public String getPassport() {return passport;}



@ManyToOne(targetEntity = Position.class,fetch=FetchType.EAGER)
@JoinColumn(name = "position_id")
@JsonManagedReference
    private Position person_position_id;

    public void setPosition(Position position) {
        this.person_position_id = position;
    }

    public Position getPosition() {
        return person_position_id;
    }

    @JsonProperty("position_name")
    @Transient
    public String getPositionName()
    {
        return person_position_id.getPosition();
    }

    @JsonProperty("position_level")
    @Transient
    public String getPositionLevel()
    {
        return person_position_id.getTolerance_level();
    }
}
