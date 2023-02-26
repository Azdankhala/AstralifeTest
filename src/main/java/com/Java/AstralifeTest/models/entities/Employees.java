package com.Java.AstralifeTest.models.entities;

import com.Java.AstralifeTest.Enum.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Cant be Null")
    @Column(name = "emp_no",length = 11)
    private int empNo;

    @NotNull(message = "Cant be Null")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "birth_date")
    private Date birthDate;

    @NotNull(message = "Cant be Null")
    @Size(max = 14, message = "key size must be 14")
    @Column(name = "first_name",length = 14,nullable = false)
    private String firstName;

    @Size(max = 16, message = "key size must be 16")
    @Column(name = "last_name",length = 16)
    private String lastName;

    @NotNull(message = "Cant be Null")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "Cant be Null")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "hire_date")
    private Date hireDate;

}
