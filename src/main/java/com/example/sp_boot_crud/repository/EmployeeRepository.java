package com.example.sp_boot_crud.repository;


import com.example.sp_boot_crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // You can add custom queries here if needed
}