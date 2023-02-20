package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.Employee;

public interface EmpRepo extends JpaRepository<Employee, Long>{

}
