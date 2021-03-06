package com.bridgelabz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bridgelabz.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
