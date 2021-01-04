package com.study.zsl.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Integer id;
    private String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
    }
}
