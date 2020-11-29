package com.bridgelabz.service;

import com.bridgelabz.dto.EmployeePayrollDTO;
import com.bridgelabz.exception.EmployeeException;
import com.bridgelabz.model.Employee;

public interface IEmployeeService {
	public Employee addEmployee(EmployeePayrollDTO employeeDTO);
	public Employee getEmployeeById(Long id) throws EmployeeException;
	public void updateEmployeeById(Long id, EmployeePayrollDTO employeeDTO) throws EmployeeException;
	public void deleteEmployeeById(Long id);
}
