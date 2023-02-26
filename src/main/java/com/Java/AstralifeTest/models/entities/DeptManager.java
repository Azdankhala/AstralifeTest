package com.Java.AstralifeTest.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "dept_manager")
public class DeptManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = Employees.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_no",referencedColumnName = "emp_no")
    private  Employees employees;

    @ManyToOne
    @JoinColumn(name = "dept_no")
    private Departments departments;

    @NotNull(message = "Cant be Null")
    @Column(name = "from_date")
    private Date fromDate;

    @NotNull(message = "Cant be Null")
    @Column(name = "to_date")
    private Date toDate;


}
