package app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Department implements Serializable{
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private int department_id;
	
	@Column(name = "department_name")
	private String department_name;
	
	
	@OneToMany(mappedBy = "department")
	private List<Course> courses;
	
	
	public Department() {}


	public int getDepartment_id() {
		return department_id;
	}


	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}


	public String getDepartment_name() {
		return department_name;
	}


	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	
}
