package com.example.StudentTest.Repo;

import com.example.StudentTest.Entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train,String> {
}
