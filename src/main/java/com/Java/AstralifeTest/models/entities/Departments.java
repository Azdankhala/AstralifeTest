package com.Java.AstralifeTest.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "departments")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Cant be Null")
    @Size(max = 4,message = "key length must be 4")
    @Column(name = "dept_no", length = 4)
    private String deptNo;

    @NotNull(message = "Cant be Null")
    @Column(name = "dept_name",length = 40)
    private String deptName;
}
