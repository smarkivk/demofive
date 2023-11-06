package registrationone.demofive.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import registrationone.demofive.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

