package com.study.zsl.service;

import com.study.zsl.dao.DepartmentDao;
import com.study.zsl.po.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentDao departmentDao;

    @Override
    public List<Department> getDepartments() {
        return departmentDao.getDepts();
    }

    @Override
    public Department getDeptById(Integer id) {
        return departmentDao.getDeptById(id);
    }

    @Override
    public void insertDept(Department department) {
        departmentDao.insertDept(department);
    }

}
