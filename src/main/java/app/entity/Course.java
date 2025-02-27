package app.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id", nullable = false)
	private int course_id;
	
	@Column(name = "course_name", nullable = false)
	private String course_name;
	
	@Column(name = "course_code", nullable = false)
	private String course_code;
	
	@Column(name = "credits", nullable = false)
	private int credits;
	
	@Column(name = "department_id", nullable = false, insertable = false, updatable = false)
	private int department_id;
	
	
	@ManyToOne
	@JoinColumn(name = "department_id", referencedColumnName = "department_id")
	private Department department;
	
	public Course() {}

	
	
	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_code() {
		return course_code;
	}

	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}



	public Department getDepartment() {
		return department;
	}



	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
	
}
