package net.karthik.ems.mapper;

import net.karthik.ems.dto.EmployeeDto;
import net.karthik.ems.entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeDto mapToEmployeeDTO(Employee employee) {
		return new EmployeeDto(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail());
	}
	
	public static Employee mapToEmployee(EmployeeDto employeedto)
	{
		return new Employee(employeedto.getId(),employeedto.getFirstName(),employeedto.getLastName(),employeedto.getEmail());
	}

}
