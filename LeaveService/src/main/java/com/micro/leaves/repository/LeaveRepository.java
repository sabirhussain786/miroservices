package com.micro.leaves.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.micro.leaves.model.Leave;
import com.micro.leaves.model.LeaveType;

import reactor.core.publisher.Flux;

@Repository
public interface LeaveRepository extends ReactiveCrudRepository<Leave, Long> {

	Flux<Leave> findByLeaveType(LeaveType leaveType);

	Flux<Leave> findByEmployeeId(Long employeeId);
	


	
//    @Query("SELECT to.uniqueOrderNumber FROM TestOrder to INNER JOIN Student st ON st.studentId = to.student.studentId WHERE st.authorisationNo= ?1")
//	Flux<Leave> findCurrentSubmittedLeaves();
}
