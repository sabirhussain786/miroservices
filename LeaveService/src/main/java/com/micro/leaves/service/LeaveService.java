package com.micro.leaves.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;

import com.micro.leaves.model.Leave;
import com.micro.leaves.model.LeaveSummary;
import com.micro.leaves.model.LeaveType;
import com.micro.leaves.repository.LeaveRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LeaveService {

    private final LeaveRepository leaveRepository;
    
    
//    private final DbClient dbClient;

    private final DatabaseClient databaseClient;
    
    @Autowired
    public LeaveService(LeaveRepository leaveRepository, DatabaseClient databaseClient) {
        this.leaveRepository = leaveRepository;
        this.databaseClient = databaseClient;
    }

    public Flux<Leave> findAll() {
        return leaveRepository.findAll();
    }
    
    public Flux<Leave> findByLeaveType(LeaveType leaveType) {
        return leaveRepository.findByLeaveType(leaveType);
    }

    public Mono<Leave> save(Leave leave) {
        return leaveRepository.save(leave);
    }

    public Mono<Leave> update(Long id, Leave leave) {
        return leaveRepository.findById(id)
                .flatMap(l -> {
                	l.setEmployeeId(leave.getEmployeeId());
                	l.setLeaveType(leave.getLeaveType());
                	l.setStatus(leave.getStatus());
                    l.setReason(leave.getReason());
                    return leaveRepository.save(l);
                });
    }

    public Mono<Void> delete(Long id) {
        return leaveRepository.deleteById(id);
    }

	public Mono<Leave> getLeaveById(Long id) {
		return leaveRepository.findById(id);
	}

	public Flux<Leave> getLeavesByEmployeeId(Long employeeId) {
		
		return leaveRepository.findByEmployeeId(employeeId);
	}

	public Flux<LeaveSummary> findCurrentSubmittedLeaves() {
		
			String sql = "SELECT e.id AS employee_id, e.name AS employee_name, \n"
					+ "       COUNT(l.id) AS current_submitted_leaves\n"
					+ "FROM employee e\n"
					+ "JOIN leave l ON e.id = l.employee_id\n"
					+ "WHERE l.status = 'pending'\n"
					+ "GROUP BY e.id, e.name;";
	    return databaseClient.execute(sql)
	            .as(LeaveSummary.class)
	            .fetch()
	            .all();
	
	}


}
