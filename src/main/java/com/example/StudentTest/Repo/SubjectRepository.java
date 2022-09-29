package com.example.StudentTest.Repo;

import com.example.StudentTest.Entity.subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<subject, String> {
}
