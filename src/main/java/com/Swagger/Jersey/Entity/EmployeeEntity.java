package com.Swagger.Jersey.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name ="employ")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "EmployeeName")
	private String EmpName;
	
	@Column(name = "EmployeeDesignation")
	private String EmpDesignation;

	@XmlElement
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@XmlElement
	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	@XmlElement
	public String getEmpDesignation() {
		return EmpDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		EmpDesignation = empDesignation;
	}

	public EmployeeEntity(long id, String empName, String empDesignation) {
		super();
		this.id = id;
		EmpName = empName;
		EmpDesignation = empDesignation;
	}

	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", EmpName=" + EmpName + ", EmpDesignation=" + EmpDesignation + "]";
	}
	
	
	
	

}
