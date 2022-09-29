package com.example.StudentTest.Entity;


import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "course")
public class Course implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Cource")
    private String Id_Cource;

    @Column(name = "Namecource")
    private String Namecourse;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Grade> grades;


    public String getId_Cource() {
        return Id_Cource;
    }

    public void setId_Cource(String id_Cource) {
        Id_Cource = id_Cource;
    }

    public String getNamecource() {
        return Namecourse;
    }

    public void setNamecource(String namecource) {
        Namecourse = namecource;
    }
}
