package com.study.zsl.service;

import com.study.zsl.dao.DepartmentDao;
import com.study.zsl.dao.EmployeeDao;
import com.study.zsl.po.Department;
import com.study.zsl.po.EmpAndDep;
import com.study.zsl.po.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<EmpAndDep> getAll() {
        List<EmpAndDep> empAndDeps = new ArrayList<>();
        for (Employee employee : employeeDao.getAll()) {
            EmpAndDep empAndDep = new EmpAndDep();
            empAndDep.setId(employee.getId());
            empAndDep.setLastName(employee.getLastName());
            empAndDep.setEmail(employee.getEmail());
            empAndDep.setGender(employee.getGender());
            Department department = departmentDao.getDeptById(employee.getDeptId());
            empAndDep.setDepartment(department);
            empAndDeps.add(empAndDep);
        }
        return empAndDeps;
    }

    @Override
    public EmpAndDep get(Integer id) {
        EmpAndDep empAndDep = new EmpAndDep();
        Employee employee = employeeDao.get(id);
        empAndDep.setId(employee.getId());
        empAndDep.setLastName(employee.getLastName());
        empAndDep.setGender(employee.getGender());
        empAndDep.setEmail(employee.getEmail());
        Department department = departmentDao.getDeptById(employee.getDeptId());
        empAndDep.setDepartment(department);
        return empAndDep;
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeDao.delete(id);
    }

    @Override
    public Employee getEmpById(Integer id) {
        return employeeDao.getEmpByDid(id);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }


    //-----------------
    @Override
    public List<EmpAndDep> getByName(String name) {
        List<EmpAndDep> empAndDeps = new ArrayList<>();
        for (Employee employee : employeeDao.getByName(name)) {
            EmpAndDep empAndDep = new EmpAndDep();
            empAndDep.setId(employee.getId());
            empAndDep.setLastName(employee.getLastName());
            empAndDep.setEmail(employee.getEmail());
            empAndDep.setGender(employee.getGender());
            Department department = departmentDao.getDeptById(employee.getDeptId());
            empAndDep.setDepartment(department);
            empAndDeps.add(empAndDep);
        }
        return empAndDeps;
    }

}
