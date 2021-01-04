package com.study.zsl.dao;

import com.study.zsl.po.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentDao {
    //获取所有的部门
    @Select("select * from department")
    List<Department> getDepts();

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(dept_name) values(#{deptName})")
    public int insertDept(Department department);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);


    @Update("update department set departmentName=#{dept_name} where id=#{id}")
    public int updateDept(Department department);
}
