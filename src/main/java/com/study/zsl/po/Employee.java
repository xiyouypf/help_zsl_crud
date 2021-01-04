package com.study.zsl.po;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer deptId;

    public Employee(String lastName, String email, Integer gender, Integer deptId) {
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.deptId = deptId;
    }
}
