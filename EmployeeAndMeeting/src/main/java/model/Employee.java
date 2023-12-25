package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_employee")
public class Employee {
	@Id
	private String employeeId;
	private String name;
	private String email;
	
	@ManyToMany(mappedBy = "employees")
	private Set<Meeting> meetings = new HashSet<Meeting>();

	public Employee() {
	}

	public Employee(String employeeId, String name, String email, Set<Meeting> meetings) {
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.meetings = meetings;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(Set<Meeting> meetings) {
		this.meetings = meetings;
	}
}
