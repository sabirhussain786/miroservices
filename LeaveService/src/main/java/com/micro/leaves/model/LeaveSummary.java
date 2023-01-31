package com.micro.leaves.model;

public class LeaveSummary {

    private Long employeeId;
    private String employeeName;
    private Integer currentSubmittedLeaves;
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Integer getCurrentSubmittedLeaves() {
		return currentSubmittedLeaves;
	}
	public void setCurrentSubmittedLeaves(Integer currentSubmittedLeaves) {
		this.currentSubmittedLeaves = currentSubmittedLeaves;
	}
	@Override
	public String toString() {
		return "LeaveSummary [employeeId=" + employeeId + ", employeeName=" + employeeName + ", currentSubmittedLeaves="
				+ currentSubmittedLeaves + "]";
	}

    
}

