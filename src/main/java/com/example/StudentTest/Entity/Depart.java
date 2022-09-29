package com.example.StudentTest.Entity;


import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "depart")
public class Depart implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_depart",length = 8)
    private String Id_depart;

    @Column(name = "Namedepart",length = 50,nullable = false)
    private String Namedepart;

    @Column(name = "address",length = 20)
    private String address;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "depart",cascade = CascadeType.ALL)
    private List<Grade> grades;

    @OneToMany(mappedBy = "depart",cascade = CascadeType.ALL)
    private List<Teacher> teachers;


    public String getId_depart() {
        return Id_depart;
    }

    public void setId_depart(String id_depart) {
        Id_depart = id_depart;
    }

    public String getNamedepart() {
        return Namedepart;
    }

    public void setNamedepart(String namedepart) {
        Namedepart = namedepart;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
