package com.example.StudentTest.Repo;


import com.example.StudentTest.Entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point, String> {


    @Query("SELECT P FROM Point P WHERE P.point_ID.Id_Stu = :id")
    List<Point> findAllId(@Param("id") String id);
}
