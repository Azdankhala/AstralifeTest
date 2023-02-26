package com.Java.AstralifeTest.repositories;

import com.Java.AstralifeTest.models.entities.DeptEmp;
import com.Java.AstralifeTest.models.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeptEmpRepository extends JpaRepository<DeptEmp,Long> {

    Optional<DeptEmp> findById(long id);
}
