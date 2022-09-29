package com.example.StudentTest.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "point")
public class Point implements Serializable {

    @EmbeddedId
    private PointID point_ID;

    @Column(name = "term")
    private int term;

    @Column(name = "point")
    private int point;


    @ManyToOne
    @JoinColumn(name = "sub_id",insertable = true,updatable = false)
    private subject subject;

    @ManyToOne
    @JoinColumn(name = "stu_id",insertable = true,updatable = false)
    private Student student;




    public String getSubID(){
        return point_ID.Id_Sub;
    }

    public String getStuId(){
        return point_ID.Id_Stu;
    }


    public void setIdStu(String id_stu){
        point_ID.Id_Stu = id_stu;
    }

    public void setIdSub(String id_sub){
        point_ID.Id_Sub = id_sub;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
