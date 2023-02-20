package Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Table(name="tbl_employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long emp_id;
	
	@Column(name = "emp_name")
	private String emp_name;
	
	@Column(name = "city")
	private String city;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_salary")
	private Salary salary;

}
