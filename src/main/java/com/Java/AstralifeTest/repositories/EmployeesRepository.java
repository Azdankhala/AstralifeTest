package com.Java.AstralifeTest.repositories;

import com.Java.AstralifeTest.models.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<Employees,Long> {
    Optional<Employees> findById(long id);
}
