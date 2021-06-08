package com.nagarro.training.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.training.model.Employee;


@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> {

}
