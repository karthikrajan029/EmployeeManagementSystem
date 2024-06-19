package net.karthik.ems.service;

import java.util.List;

import net.karthik.ems.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);

	EmployeeDto getEmployeeById(Long employeeId);

	List<EmployeeDto> getAllEmployees();
   
	void deleteEmployee(long employeeId);

	EmployeeDto updateEmployee(long employeeId, EmployeeDto updatedEmployee);

	

}
