package com.study.zsl.dao;

import com.study.zsl.po.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeDao {
    //查询所有
    @Select("select * from employee")
    List<Employee> getAll();

    //通过id来查询员工
    @Select("select * from employee where id=#{id}")
    Employee get(Integer id);

    //保存员工信息
    @Insert("insert into employee (last_name, email, gender, dept_id) values(#{lastName},#{email},#{gender},#{deptId})")
    void save(Employee employee);

    //根据id删除员工信息
    @Delete("delete from employee where id=#{id}")
    void delete(Integer id);

    @Select("select * from employee where dept_id=#{emp.department.id}")
    Employee getEmpByDid(Integer id);

    @Update("update employee set last_name=#{lastName},email=#{email},gender=#{gender},dept_id=#{deptId} where id=#{id}")
    void update(Employee employee);

    //------------------
    @Select("select * from employee where last_name like '%${name}%'")
    List<Employee> getByName(String name);
}
