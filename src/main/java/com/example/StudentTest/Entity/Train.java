package com.example.StudentTest.Entity;


import javax.persistence.*;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "train")
public class Train implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Type",length = 8)
    private String Id_Type;

    @Column(name = "Nametype",length = 50,nullable = false)
    private String Nametype;

    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    private List<Grade> grades;


    public String getId_Type() {
        return Id_Type;
    }

    public void setId_Type(String id_Type) {
        Id_Type = id_Type;
    }

    public String getNametype() {
        return Nametype;
    }

    public void setNametype(String nametype) {
        Nametype = nametype;
    }
}
