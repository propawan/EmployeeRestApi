package com.springrest.springrest.services;

import com.springrest.springrest.dao.DepartmentDao;
import com.springrest.springrest.dao.EmployeeDao;
import com.springrest.springrest.entities.Department;
import com.springrest.springrest.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    public EmployeeServiceImpl() {

    }

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.findAll()
                .stream()
                .filter(Employee::isStatus)
                .collect(Collectors.toList());
    }

    @Override
    public Employee getEmployee(long employeeId) {
        Employee employee = employeeDao.getById(employeeId);
        if(employee.isStatus()){
            return employee;
        }
        return null;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setStatus(true);
        long departmentCode = employee.getDepartment().getDeptCode();
        List<Department> departments = departmentDao.findAll().stream().filter(department -> department.getDeptCode()==departmentCode).collect(Collectors.toList());
        if(!departments.isEmpty()){
            Department department = departments.get(0);
            employee.setDepartment(department);
            employeeDao.save(employee);
        }
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(long employeeId) {
        Optional<Employee> employee = employeeDao.findById(employeeId);
        if(employee.isPresent()){
            Employee emp = employee.get();
            emp.setStatus(false);
            employeeDao.save(emp);
        }
    }

    @Override
    public List<Employee> getEmployeeByDept(long deptCode) {
        return employeeDao.getEmployeesByDept(deptCode);
    }
}
