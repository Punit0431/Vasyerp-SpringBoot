package com.example.demo.Model;



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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_Student")
public class StudentVo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long student_id;
	
	@Column(name = "Firstname")
	private String firstname;
	
	@Column(name = "Lastname")
	private String lastname;
	
	@Column(name = "Mob_no")
	private long mobileNo;
	
	@Column(name = "Email")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_id", referencedColumnName = "salary_id")
    private Salary salary;


}
