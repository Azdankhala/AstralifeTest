package com.Java.AstralifeTest.repositories;

import com.Java.AstralifeTest.models.entities.DeptManager;
import com.Java.AstralifeTest.models.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeptManagerRepository extends JpaRepository<DeptManager,Long> {
    Optional<DeptManager> findById(long id);
}
