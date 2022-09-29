package com.example.StudentTest.Entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class PointID implements Serializable {

    @Column(name = "Id_Stu",length = 10)
    protected String Id_Stu;

    @Column(name = "Id_Sub",length = 8)
    protected String Id_Sub;

}
