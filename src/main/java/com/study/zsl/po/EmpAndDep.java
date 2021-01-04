package com.study.zsl.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpAndDep {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Department department;

    public EmpAndDep(String lastName, String email, Integer gender, Department department) {
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
    }
}
