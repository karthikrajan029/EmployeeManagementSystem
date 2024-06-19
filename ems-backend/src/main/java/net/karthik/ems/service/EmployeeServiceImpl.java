package net.karthik.ems.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.karthik.ems.dto.EmployeeDto;
import net.karthik.ems.entity.Employee;
import net.karthik.ems.exception.ResourceNotFoundException;
import net.karthik.ems.mapper.EmployeeMapper;
import net.karthik.ems.repository.EmployeeRepository;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee=employeeRepository.save(employee);
		
		
		// TODO Auto-generated method stub
		return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
	}
	
	@Override
	public EmployeeDto getEmployeeById(Long employeeId)
	
	{
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee is not exists with given id :"+employeeId));
		
		return EmployeeMapper.mapToEmployeeDTO(employee);
	}
	
	@Override
	public List<EmployeeDto> getAllEmployees(){
		List<Employee> employees=employeeRepository.findAll();
		return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDTO(employee)).collect(Collectors.toList());
	}
	
	@Override
	public EmployeeDto updateEmployee(long employeeId,EmployeeDto updatedEmployee){
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee is not exists in given id" +employeeId));
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		Employee updatedemployeeDb=employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDTO(updatedemployeeDb);
		
	}
		@Override
		public void deleteEmployee(long employeeId){
			Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Emloyee is not exisits with given id:" +employeeId));
			employeeRepository.deleteById(employeeId);			
		}
		
	}


