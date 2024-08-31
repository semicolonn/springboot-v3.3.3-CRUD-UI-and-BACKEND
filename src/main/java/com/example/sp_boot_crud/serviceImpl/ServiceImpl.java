package com.example.sp_boot_crud.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sp_boot_crud.model.Employee;
import com.example.sp_boot_crud.repository.EmployeeRepository;
import com.example.sp_boot_crud.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class ServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository empolyeeRepository;
	
	@Override
	public List<Employee> getAllEmployee() {

		return (List<Employee>) empolyeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {

        return empolyeeRepository.findById(id).get();	}

	@Override
	public void saveEmployee(Employee employee) {
		empolyeeRepository.save(employee);		
	}

	@Override
	public void deleteEmployee(Long id) {
		empolyeeRepository.deleteById(id);;
		
	}

	@Override
	public void update(Employee employee) {
		empolyeeRepository.save(employee);
		
	}




}
