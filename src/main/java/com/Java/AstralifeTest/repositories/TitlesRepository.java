package com.Java.AstralifeTest.repositories;

import com.Java.AstralifeTest.models.entities.Employees;
import com.Java.AstralifeTest.models.entities.Titles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TitlesRepository extends JpaRepository<Titles,Long> {
    Optional<Titles> findById(long id);
}
