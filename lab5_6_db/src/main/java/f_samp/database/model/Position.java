package f_samp.database.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import f_samp.database.model.Persons;
import java.util.List;

@Entity
@Table(name="Position")

public class Position implements Serializable{

    public Position(){}

    public Position( String position, String tolerance_level) {

        this.position = position;
        this.tolerance_level = tolerance_level;
    }

    public Position(Integer id,String position, String tolerance_level) {
        this.id=id;
        this.position = position;
        this.tolerance_level = tolerance_level;
    }


    @Id
    @Column(name="position_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public void setId(Integer id) {this.id=id;}

    public Integer getId() {return id;}


    @OneToMany(targetEntity = Persons.class, mappedBy = "person_position_id" , fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonBackReference
    private List<Persons> personList;


    @Column(name="position")
    private String position;

    public void setPosition(String position) {this.position=position;}

    public String getPosition() {return position;}

    @Column(name="tolerance_level")
    private String tolerance_level;

    public void setTolerance_level(String tolerance_level) {this.tolerance_level=tolerance_level;}

    public String getTolerance_level() {return tolerance_level;}

}
