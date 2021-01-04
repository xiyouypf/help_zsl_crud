package com.study.zsl.service;

import com.study.zsl.po.Department;

import java.util.Collection;
import java.util.List;

public interface DepartmentService {
    List<Department> getDepartments();

    Department getDeptById(Integer id);

    void insertDept(Department department);
}
