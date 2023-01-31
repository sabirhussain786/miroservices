package com.micro.employee.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.micro.employee.model.Employee;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long>{

}
