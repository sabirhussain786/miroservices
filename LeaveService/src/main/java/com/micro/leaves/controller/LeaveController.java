package com.micro.leaves.controller;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.leaves.model.Leave;
import com.micro.leaves.model.LeaveSummary;
import com.micro.leaves.model.LeaveType;
import com.micro.leaves.service.LeaveService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/leave")
public class LeaveController {

    private final LeaveService leaveService;

    @Autowired
    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }
    
    @GetMapping("/{id}")
    public Mono<Leave> getLeaveById(@PathVariable("id") Long id) {
        return leaveService.getLeaveById(id);
    }

    @GetMapping
    public Flux<Leave> getAllLeaves() {
        return leaveService.findAll();
    }
    
    @GetMapping("/currentsubmittedleaves")
    public Flux<LeaveSummary> getCurrentSubmittedLeaves() {
        return leaveService.findCurrentSubmittedLeaves();
    }

    @GetMapping("/leavetype/{leaveType}")
    public Flux<Leave> getLeavesByType(@PathVariable("leaveType") LeaveType leaveType) {
        return leaveService.findByLeaveType(leaveType);
    }
    
    @GetMapping("/employee/{employeeId}")
    public Flux<Leave> getLeavesByEmployeeId(@PathVariable Long employeeId) {
        return leaveService.getLeavesByEmployeeId(employeeId);
    }

    @PostMapping
    public Mono<Leave> createLeave(@Valid @RequestBody Leave leave) {
        return leaveService.save(leave);
    }

    @PutMapping("/{id}")
    public Mono<Leave> updateLeave(@PathVariable("id") Long id, @Valid @RequestBody Leave leave) {
        return leaveService.update(id, leave);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteLeave(@PathVariable("id") Long id) {
        return leaveService.delete(id);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Mono<ResponseEntity<String>> handleConstraintViolationException(ConstraintViolationException e) {
        return Mono.just(ResponseEntity.badRequest().body(e.getMessage()));
    }
}

