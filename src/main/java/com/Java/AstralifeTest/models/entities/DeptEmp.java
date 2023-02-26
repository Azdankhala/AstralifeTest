package com.Java.AstralifeTest.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "dept_name")
public class DeptEmp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Cant be Null")
    @Column(name = "from_date")
    private Date fromDate;

    @NotNull(message = "Cant be Null")
    @Column(name = "to_date")
    private Date toDate;

    @ManyToOne(targetEntity = Employees.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_no",referencedColumnName = "emp_no")
    private  Employees employees;

    @ManyToOne
    @JoinColumn(name = "dept_no", referencedColumnName = "dept_no")
    private Departments departments;
}
