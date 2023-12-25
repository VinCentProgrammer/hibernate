package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_meeting")
public class Meeting {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String positionMeeting;
	private Date dateTimeMeeting;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_employee_meeting", 
	joinColumns = { @JoinColumn(name = "meetingId") }, 
	inverseJoinColumns = { @JoinColumn(name = "employeeId") })
	private Set<Employee> employees = new HashSet<Employee>();

	public Meeting() {
		// TODO Auto-generated constructor stub
	}

	public Meeting(String name, String positionMeeting, Date dateTimeMeeting) {
		this.name = name;
		this.positionMeeting = positionMeeting;
		this.dateTimeMeeting = dateTimeMeeting;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPositionMeeting() {
		return positionMeeting;
	}

	public void setPositionMeeting(String positionMeeting) {
		this.positionMeeting = positionMeeting;
	}

	public Date getDateTimeMeeting() {
		return dateTimeMeeting;
	}

	public void setDateTimeMeeting(Date dateTimeMeeting) {
		this.dateTimeMeeting = dateTimeMeeting;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
