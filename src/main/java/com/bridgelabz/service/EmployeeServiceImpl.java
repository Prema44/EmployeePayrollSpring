package com.bridgelabz.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.dto.EmployeePayrollDTO;
import com.bridgelabz.exception.EmployeeException;
import com.bridgelabz.model.Employee;
import com.bridgelabz.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	@Autowired
	IEmployeeRepository employeeRepository;
	
	@Override
    public List<Employee> getEmployees(){
    List<Employee> empList = new ArrayList<>();
    empList = employeeRepository.findAll();
    return empList;
   }
	
	@Override
	public Employee addEmployee(EmployeePayrollDTO employeeDTO) throws EmployeeException{
		int count = (int) employeeRepository.count();
		int newId = 0;
		Employee emp = null;
		if(count == 0)
		{
			emp = new Employee(newId + 1, employeeDTO);			
		}else {
			newId = this.getEmployees().get(count - 1).getId();
			emp = new Employee(newId + 1, employeeDTO);
		}
		employeeRepository.save(emp);
		return employeeRepository.findById(newId + 1)
				      .orElseThrow(() -> new EmployeeException("Employee not added"));
	}
	
	@Override
	public Employee getEmployeeById(int id) throws EmployeeException {
		return employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("Employee not found"));
	}
	
	@Override
	public Employee updateEmployeeById(int id, EmployeePayrollDTO employeeDTO) throws EmployeeException {
		Employee employee = this.getEmployeeById(id);
		employee.setName(employeeDTO.getName());
		employee.setSalary(employeeDTO.getSalary());
		employeeRepository.save(employee);
		return employeeRepository.findById(id).get();
	}
	
	@Override
	public void deleteEmployeeById(int id) throws EmployeeException {
		employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("Employee to be deleted not found"));
		employeeRepository.deleteById(id);
	}

} 
