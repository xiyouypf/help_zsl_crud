package com.study.zsl.controller;

import com.study.zsl.po.Department;
import com.study.zsl.po.EmpAndDep;
import com.study.zsl.po.Employee;
import com.study.zsl.service.DepartmentService;
import com.study.zsl.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    //---------------
    /**
     * 查询所有员工返回列表页面
     * thymeleaf默认会拼串
     * classpath:/templates/xxx.html
     */
    @GetMapping("/emps")
    public String list(Model model, HttpServletRequest request) throws Exception {
        String name = request.getParameter("name");
        if (name != null) {
            name = name.trim();
        }
        System.out.println(name);
        if (name == null) {
            List<EmpAndDep> empAndDeps = employeeService.getAll();
            model.addAttribute("emps", empAndDeps);
            return "emp/list";
        } else {
            List<EmpAndDep> empAndDeps = employeeService.getByName(name);
            model.addAttribute("emps", empAndDeps);
            return "emp/list";
        }
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        List<Department> departments = departmentService.getDepartments();
        model.addAttribute("depts", departments);
        //来到添加页面
        return "emp/add";
    }

    //添加员工
    @PostMapping("/emp")
    public String addEmp(EmpAndDep empAndDep) {
        Employee employee = new Employee();
        employee.setLastName(empAndDep.getLastName());
        employee.setEmail(empAndDep.getEmail());
        employee.setGender(empAndDep.getGender());
        employee.setDeptId(empAndDep.getDepartment().getId());
        System.out.println("--->>>" + employee);
        if (empAndDep.getId() != null) {
            employee.setId(empAndDep.getId());
            employeeService.update(employee);
            return "redirect:/emps";
        }
        employeeService.save(employee);
        return "redirect:/emps";
    }

    //来到修改页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        EmpAndDep empAndDep = employeeService.get(id);
        System.out.println("vvvvvvv" + empAndDep.toString());
        model.addAttribute("emp", empAndDep);
        //页面要显示所有的部门列表
        List<Department> departments = departmentService.getDepartments();
        model.addAttribute("depts", departments);
        //回到修改页面(add是一个修改添加二合一的页面)
        return "emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String update(EmpAndDep empAndDep) {
        System.out.println("修改的员工:" + empAndDep);
        Employee employee = new Employee();
        employee.setId(empAndDep.getId());
        employee.setLastName(empAndDep.getLastName());
        employee.setEmail(empAndDep.getEmail());
        employee.setGender(empAndDep.getGender());
        employee.setDeptId(empAndDep.getDepartment().getId());
        System.out.println(employee);
        employeeService.delete(employee.getId());
        employeeService.update(employee);
        return "redirect:/emps";
    }

    //员工删除
    @GetMapping("/delemp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.delete(id);
        return "redirect:/emps";
    }
}
