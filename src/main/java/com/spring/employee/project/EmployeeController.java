package com.spring.employee.project;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;




	@RestController
	@RequestMapping("/employee")
	public class EmployeeController {

		@Autowired
	    EmployeeRepository employeerepository;
		
		 @PutMapping("/{id}")
		 @Operation(summary = "Update Employee Data")
		 public Employee update( @RequestBody Employee newemp,@PathVariable Long id) {
		     return employeerepository.findById(id).map(emp -> {
		        emp.setName(newemp.getName());
		        emp.setAddress(newemp.getAddress());
		        emp.setPhone(newemp.getPhone());
		        return employeerepository.save(emp);
		        }
		        ).orElse(null);
		    }

	    @GetMapping
	    @Operation(summary = "Get all Employee Data")
	    public List<Employee> getAllId() {
	    	String msg="This is Get Message";
	    	System.out.println(msg);
	        return employeerepository.findAll();
	        
	    }
	    
	    @PostMapping
	    @Operation(summary = "Add New Employee Data")
	    public Employee emp(@RequestBody Employee employee) {
	    	String msg="This is Post Message";
	    	System.out.println(msg);
	        return employeerepository.save(employee);
	    }

	    @GetMapping("/{id}")
	    @Operation(summary = "Get Employee Data by ID")
	    public Employee getById(@PathVariable Long id) {
	        return employeerepository.findById(id).orElse(null);
	    }

	    @DeleteMapping("employee/{id}")
	    @Operation(summary = "Delete Employee Data by ID")
	    public void delete(@PathVariable Long id) {
	    	employeerepository.deleteById(id);
	    }

	    }
	    

