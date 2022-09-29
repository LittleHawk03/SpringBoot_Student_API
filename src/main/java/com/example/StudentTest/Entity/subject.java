package com.example.StudentTest.Entity;

import org.springframework.data.relational.core.mapping.Table;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "subject")
public class subject implements Serializable {


//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_Sub",length = 10)
    private String Id_Sub;

    @Column(name = "Namesub",length = 10)
    private String NameSubject;

    @Column(name = "SoTC")
    private int SoTC;

    @OneToMany(mappedBy = "subject",cascade = CascadeType.ALL)
    private List<Point> points;




    public String getId_Sub() {
        return Id_Sub;
    }

    public void setId_Sub(String id_Sub) {
        Id_Sub = id_Sub;
    }

    public String getNameSubject() {
        return NameSubject;
    }

    public void setNameSubject(String nameSubject) {
        NameSubject = nameSubject;
    }

    public int getSoTC() {
        return SoTC;
    }

    public void setSoTC(int soTC) {
        SoTC = soTC;
    }
}
