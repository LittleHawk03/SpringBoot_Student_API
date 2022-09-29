package com.example.StudentTest.Repo;


import com.example.StudentTest.Entity.Depart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartRepository extends JpaRepository<Depart, String> {
}
