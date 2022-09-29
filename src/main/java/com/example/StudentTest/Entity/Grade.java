package com.example.StudentTest.Entity;


import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "grade")
public class Grade implements Serializable {

    @Id
    @Column(name = "Id_Grade",length = 8)
    private String Id_Grade;


    @Column(name = "Nameclass",length = 50,nullable = false)
    private String Nameclass;


    @ManyToOne
    @JoinColumn(name = "Id_Course")
    private Course course;



//    @Column(name = "Id_Type", length = 8)
//    private String Id_Type;


    @OneToMany(mappedBy = "grade",cascade = CascadeType.ALL)
    private List<Student> studentList;



    @ManyToOne
    @JoinColumn(name = "Id_depart")
    private Depart depart;


    @ManyToOne
    @JoinColumn(name = "Id_Type")
    private Train train;


    public Course getCource() {
        return course;
    }

    public void setCource(Course cource) {
        this.course = cource;
    }

    public Depart getDepart() {
        return depart;
    }

    public void setDepart(Depart depart) {
        this.depart = depart;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getId_Grade() {
        return Id_Grade;
    }

    public void setId_Grade(String id_Grade) {
        Id_Grade = id_Grade;
    }

    public String getNameclass() {
        return Nameclass;
    }

    public void setNameclass(String nameclass) {
        Nameclass = nameclass;
    }



}
