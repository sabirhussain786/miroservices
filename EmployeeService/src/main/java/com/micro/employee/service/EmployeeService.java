package com.micro.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.employee.model.Employee;
import com.micro.employee.repository.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Flux<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Mono<Employee> save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Mono<Employee> update(Long id, Employee employee) {
        return employeeRepository.findById(id)
                .flatMap(e -> {
                    e.setName(employee.getName());
                    e.setEmail(employee.getEmail());
                    return employeeRepository.save(e);
                });
    }

    public Mono<Void> delete(Long id) {
        return employeeRepository.deleteById(id);
    }

	public Mono<Employee> getEmployeeById(Long id) {
		
		return employeeRepository.findById(id);
	}
}
