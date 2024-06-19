package net.karthik.ems.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import net.karthik.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	
}
