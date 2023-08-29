package com.example.employeesystembackend.controller;

import com.example.employeesystembackend.entity.EmployeeEntity;
import com.example.employeesystembackend.model.EmployeeModel;
import com.example.employeesystembackend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public EmployeeModel createEmployee(@RequestBody EmployeeModel employeeModel){
        return employeeService.createEmployee(employeeModel);
    }

    @GetMapping("/employees")
    public List<EmployeeModel> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        boolean deleted = false;
        deleted = employeeService.deleteEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable Long id){
        EmployeeModel employeeModel = null;
        employeeModel = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeModel);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable Long id,
                                                        @RequestBody EmployeeModel employeeModel) {

        employeeModel = employeeService.updateEmployee(id, employeeModel);

        return ResponseEntity.ok(employeeModel);
    }

}
