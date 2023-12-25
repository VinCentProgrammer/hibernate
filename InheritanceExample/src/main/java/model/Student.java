package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_student")
public class Student extends Person {
	private double gpa;

	public Student() {
		super();
	}

	public Student(int personId, String name, Date dateOfBirth, boolean gender, double gpa) {
		super(personId, name, dateOfBirth, gender);
		this.gpa = gpa;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

}
