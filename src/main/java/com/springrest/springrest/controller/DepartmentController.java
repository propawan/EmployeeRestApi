package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Department;
import com.springrest.springrest.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @PutMapping("/departments")
    public Department updateDepartment(@RequestBody Department department){
        try{
            return departmentService.updateDepartment(department);
        }
        catch (Exception exception){
            return null;
        }
    }
}
