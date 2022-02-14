package com.springtraining.dto.rest.api.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springtraining.dto.rest.api.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
