package com.springrest.springrest.services;

import com.springrest.springrest.dao.DepartmentDao;
import com.springrest.springrest.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> getDepartments() {
        return departmentDao.findAll();
    }

    @Override
    public Department updateDepartment(Department department) {
        try{
            departmentDao.save(department);
            return department;
        }
        catch (Exception exception){
            return null;
        }
    }
}
