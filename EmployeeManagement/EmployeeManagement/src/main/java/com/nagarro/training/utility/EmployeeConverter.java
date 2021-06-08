package com.nagarro.training.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.nagarro.training.dto.EmployeeDto;
import com.nagarro.training.model.Employee;


public class EmployeeConverter {
	public EmployeeDto toEmployeeDto(Employee employee) {

		EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getName(), employee.getLocation(),
				employee.getEmail(), employee.getDob().toString());
		return employeeDto;
	}

	public Employee toEmployee(EmployeeDto employeeDto) {
		LocalDate dob = LocalDate.parse(employeeDto.getDob(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Employee employee = new Employee(employeeDto.getName(), employeeDto.getLocation(), employeeDto.getEmail(), dob);
		return employee;
	}

	public Employee toEmployeeWithId(EmployeeDto employeeDto) {
		LocalDate dob = LocalDate.parse(employeeDto.getDob(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Employee employee = new Employee(employeeDto.getId(), employeeDto.getName(), employeeDto.getLocation(),
				employeeDto.getEmail(), dob);
		return employee;
	}
}
