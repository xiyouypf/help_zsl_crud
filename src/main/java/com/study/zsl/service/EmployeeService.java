package com.study.zsl.service;

import com.study.zsl.po.EmpAndDep;
import com.study.zsl.po.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmpAndDep> getAll();

    EmpAndDep get(Integer id);

    void save(Employee employee);

    void delete(Integer id);

    Employee getEmpById(Integer id);

    void update(Employee employee);

    //-------------------
    List<EmpAndDep> getByName(String name);

}
