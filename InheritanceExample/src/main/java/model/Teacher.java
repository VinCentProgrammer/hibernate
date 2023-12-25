package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_teacher")
public class Teacher extends Person {
	private String subjectInCharge;

	public Teacher() {
		super();
	}

	public Teacher(int personId, String name, Date dateOfBirth, boolean gender, String subjectInCharge) {
		super(personId, name, dateOfBirth, gender);
		this.subjectInCharge = subjectInCharge;
	}

	public String getSubjectInCharge() {
		return subjectInCharge;
	}

	public void setSubjectInCharge(String subjectInCharge) {
		this.subjectInCharge = subjectInCharge;
	}

}
