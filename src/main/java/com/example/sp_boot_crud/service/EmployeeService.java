package com.example.sp_boot_crud.service;

import java.util.List;


import com.example.sp_boot_crud.model.Employee;

public interface EmployeeService{
	
    List<Employee> getAllEmployee();

    Employee getEmployeeById(Long id);

    void saveEmployee(Employee employee);

    void deleteEmployee(Long id);

	void update(Employee employee);
}
