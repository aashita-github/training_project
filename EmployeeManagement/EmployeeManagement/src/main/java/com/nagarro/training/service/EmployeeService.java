package com.nagarro.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.dao.EmployeeDao;
import com.nagarro.training.dto.EmployeeDto;
import com.nagarro.training.model.Employee;
import com.nagarro.training.utility.EmployeeConverter;


@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	private EmployeeConverter employeeConverter = new EmployeeConverter();

	public List<EmployeeDto> getAllEmployees() {
		List<EmployeeDto> employeeDtos = new ArrayList<>();
		List<Employee> employees = new ArrayList<>();
		employeeDao.findAll().forEach(employees::add);

		for (Employee employee : employees) {
			employeeDtos.add(employeeConverter.toEmployeeDto(employee));
		}
		return employeeDtos;
	}

	public EmployeeDto getEmployee(long id) {
		return employeeConverter.toEmployeeDto(employeeDao.findById(id).get());
	}

	public void addEmployee(EmployeeDto employeeDto) {
		employeeDao.save(employeeConverter.toEmployee(employeeDto));
	}

	public void updateEmployee(EmployeeDto employeeDto) {
		employeeDao.save(employeeConverter.toEmployeeWithId(employeeDto));
	}

	public void deleteEmployee(long id) {
		employeeDao.deleteById(id);
	}

}
