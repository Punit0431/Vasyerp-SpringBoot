package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Salary")
public class Salary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sal_id;
	
	@Column(name = "salary")
	private long salary;
	
	

}
