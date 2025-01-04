package app.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name = "students")
public class Student implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int student_id;
	
	@Column(name = "first_name", length = 50)
	private String first_name;
	
	@Column(name = "last_name", length = 50)
	private String last_name;
	
	@Column(name = "email", length = 100)
	private String email;
	
	@Column(name = "date_of_birth", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDate date_of_birth;
	
	@Column(name = "gender")
	private char gender;
	
	@Column(name = "phone", length = 15)
	private String phone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "enrollemnt_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDate enrollment_date;
	
	
	
	public Student() {}



	public int getStudnet_id() {
		return student_id;
	}



	public void setStudnet_id(int studnet_id) {
		this.student_id = studnet_id;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}



	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}



	public char getGender() {
		return gender;
	}



	public void setGender(char gender) {
		this.gender = gender;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public LocalDate getEnrollment_date() {
		return enrollment_date;
	}



	public void setEnrollment_date(LocalDate enrollment_date) {
		this.enrollment_date = enrollment_date;
	}
	
	
	
}
