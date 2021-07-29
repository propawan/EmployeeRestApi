package com.springrest.springrest.services;

import com.springrest.springrest.entities.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> getDepartments();
    public Department updateDepartment(Department department);
}
