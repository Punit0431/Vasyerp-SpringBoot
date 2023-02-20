package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.Salary;

public interface SalaryRepo extends JpaRepository<Salary, Long>{

}
