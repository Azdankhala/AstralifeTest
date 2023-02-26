package com.Java.AstralifeTest.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Salaries")
public class Salaries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = Employees.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_no",referencedColumnName = "emp_no")
    private Employees employees;

    @NotNull(message = "Cant be Null")
    @Column(length = 11,nullable = false)
    private int salary;

    @NotNull(message = "Cant be Null")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "from_date")
    private Date fromDate;

    @NotNull(message = "Cant be Null")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "to_date")
    private Date toDate;

}
