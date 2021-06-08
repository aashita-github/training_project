package com.nagarro.training.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.dto.EmployeeDto;
import com.nagarro.training.service.EmployeeService;


@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employees")
	public List<EmployeeDto> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@RequestMapping("/employees/{id}")
	public EmployeeDto getEmployee(@PathVariable long id) {
		return employeeService.getEmployee(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employees")
	public void addEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
		employeeService.addEmployee(employeeDto);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/employees")
	public void updateEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
		employeeService.updateEmployee(employeeDto);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
	}
}
