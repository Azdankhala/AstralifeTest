package com.Java.AstralifeTest.repositories;

import com.Java.AstralifeTest.models.entities.Employees;
import com.Java.AstralifeTest.models.entities.Salaries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalariesRepository extends JpaRepository<Salaries,Long> {

    Optional<Salaries> findById(long id);
}
