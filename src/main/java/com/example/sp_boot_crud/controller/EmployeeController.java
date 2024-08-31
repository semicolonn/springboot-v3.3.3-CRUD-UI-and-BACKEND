package com.example.sp_boot_crud.controller;


import com.example.sp_boot_crud.model.Employee;
import com.example.sp_boot_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
    @GetMapping("/")
    public ModelAndView welcomePage(){

       return new ModelAndView("welcome");
    }

    
    //get all the employee table
    
    @GetMapping("/employee")
    public ModelAndView employeeList(){

        ModelAndView model =new ModelAndView();
      List<Employee> employee = employeeService.getAllEmployee();
        model.addObject("employee", employee);
        model.setViewName("index");
      return model;
  }
    
    // add course Page

    @GetMapping("/addEmployeePage")
    public ModelAndView addEmployee(){

          Employee employee = new Employee();
          ModelAndView modelAndView = new ModelAndView();
          modelAndView.addObject("employeeForm",employee);
          modelAndView.setViewName("add-employee");
        return modelAndView;
    }


    // add Employee

    @PostMapping("/addEmployee")
    public ModelAndView addEmployee(@ModelAttribute("employeeForm") Employee employee){

          employeeService.saveEmployee(employee);
        return new ModelAndView("redirect:/employee");
    }

    // Delete List

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee"; 
    }
    
	// edit employee

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model){
        Employee employee =employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit-employee";
    }
    
    
    @PostMapping("/edit")
    public ModelAndView updateTopic(@ModelAttribute("topic") Employee employee){
        employeeService.update(employee);
       return new ModelAndView("redirect:/employee");
    }
    
}