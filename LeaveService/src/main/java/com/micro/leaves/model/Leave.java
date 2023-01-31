package com.micro.leaves.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("leave")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Leave {
	
	@Id
	private Long id;
	@Column("employee_id")
	private Long employeeId;
	@Column
	private LeaveType leaveType;
	private LeaveStatus status;
	private String reason;	
}


