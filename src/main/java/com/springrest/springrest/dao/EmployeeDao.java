package com.springrest.springrest.dao;

import com.springrest.springrest.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Long> {
    @Query("from employee where dept_code = ?1")
    List<Employee> getEmployeesByDept(@Param("depart") Long depart);
}
