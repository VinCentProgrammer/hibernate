package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_author")
public class Author {
	@Id
	private String authorId;
	private String name;
	private Date dateOfBirth;
	
	public Author() {
		// TODO Auto-generated constructor stub
	}
	
	public Author(String authorId) {
		this.authorId = authorId;
	}
	
	public Author(String authorId, String name, Date dateOfBirth) {
		this.authorId = authorId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
}
