package com.springrest.springrest.controller;

import com.springrest.springrest.constants.AppConstant;
import com.springrest.springrest.entities.Employee;
import com.springrest.springrest.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AppConstant appConstant;

    @GetMapping("/home")
    public String home(){
        return "This is Home";
    }

    // Get Employees
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return this.employeeService.getEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable long employeeId){
        return this.employeeService.getEmployee(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return this.employeeService.addEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return this.employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable String employeeId){
        try{
            this.employeeService.deleteEmployee(Long.parseLong(employeeId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get employees by department.

    @GetMapping("/employees/dept/{deptCode}")
    public List<Employee> getEmployeeByDept(@PathVariable long deptCode){
        return employeeService.getEmployeeByDept(deptCode);
    }

    // Pagination
    @GetMapping("/employees/record")
    public List<Employee> getEmployeesPagination(@RequestParam int page){
        List<Employee> employeeList = this.employeeService.getEmployees();
        int start = (page - 1) * appConstant.getDefaultCount();
        int end = (page) * appConstant.getDefaultCount();

        if(start >= employeeList.size()){
            return null;
        }

        List<Employee> result = new ArrayList<>();
        for(int i = start;i<end&&i<employeeList.size();i++){
            result.add(employeeList.get(i));
        }

        return result;
    }
}
