package com.springrest.springrest.services;

import com.springrest.springrest.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getEmployees();
    public Employee getEmployee(long employeeId);
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(long employeeId);
    public List<Employee> getEmployeeByDept(long deptCode);
}
