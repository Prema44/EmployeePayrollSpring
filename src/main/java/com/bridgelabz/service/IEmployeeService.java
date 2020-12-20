package com.bridgelabz.service;

import java.util.List;

import com.bridgelabz.dto.EmployeePayrollDTO;
import com.bridgelabz.exception.EmployeeException;
import com.bridgelabz.model.Employee;

public interface IEmployeeService {
	List<Employee> getEmployees();
	Employee addEmployee(EmployeePayrollDTO employeeDTO) throws EmployeeException;
	Employee getEmployeeById(int empId) throws EmployeeException;
	Employee updateEmployeeById(int id, EmployeePayrollDTO employeeDTO) throws EmployeeException;
	void deleteEmployeeById(int id) throws EmployeeException;
}
