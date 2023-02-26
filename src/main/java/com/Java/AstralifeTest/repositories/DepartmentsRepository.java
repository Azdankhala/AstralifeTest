package com.Java.AstralifeTest.repositories;

import com.Java.AstralifeTest.models.entities.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentsRepository extends JpaRepository<Departments, Long> {
    Departments findById(long id);

}
