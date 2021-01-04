package com.study.zsl.controller;

import com.study.zsl.po.Department;
import com.study.zsl.po.Employee;
import com.study.zsl.service.DepartmentService;
import com.study.zsl.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DeptController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {
        return departmentService.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department) {
        departmentService.insertDept(department);
        return department;
    }

//    @GetMapping("/emp/{id}")
//    public Employee getEmpById(@PathVariable("id") Integer id) {
//        return employeeService.getEmpById(id);
//    }
}
