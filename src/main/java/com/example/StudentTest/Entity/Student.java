package com.example.StudentTest.Entity;


import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "Student")
public class Student implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Stu",length = 10)
    private String Id_Stu;

    @Column(name = "Fullname", length = 30)
    private String FullName;

    @Column(name = "Gender", length = 7)
    private String Gender;

    @Column(name = "Birthday")
    private LocalDate BirthDay;

    @Column(name = "Provide", length = 20)
    private String Provide;


    @ManyToOne
    @JoinColumn(name = "Id_Grade")
    private Grade grade;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Point> points;




    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }



    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }


    public String getId_Stu() {
        return Id_Stu;
    }

    public void setId_Stu(String id_Stu) {
        Id_Stu = id_Stu;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public LocalDate getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        BirthDay = birthDay;
    }

    public String getProvide() {
        return Provide;
    }

    public void setProvide(String provide) {
        Provide = provide;
    }


}


