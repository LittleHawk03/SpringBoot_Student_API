package com.example.StudentTest.Entity;


import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_tea",length = 10)
    private String Id_tea;

    @Column(name = "Fullname",length = 10,nullable = false)
    private String fullname;

    @Column(name = "Gender",length = 7)
    private String Gender;

    @Column(name = "Birthday")
    private Date Birthday;

    @Column(name = "Provide",length = 20)
    private String Provide;

    @ManyToOne
    @JoinColumn(name = "Id_depart")
    private Depart depart;

    public Depart getDepart() {
        return depart;
    }

    public void setDepart(Depart depart) {
        this.depart = depart;
    }

    public String getId_tea() {
        return Id_tea;
    }

    public void setId_tea(String id_tea) {
        Id_tea = id_tea;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public String getProvide() {
        return Provide;
    }

    public void setProvide(String provide) {
        Provide = provide;
    }
}
