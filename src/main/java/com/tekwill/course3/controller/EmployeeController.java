package com.tekwill.course3.controller;

import com.tekwill.course3.dto.Employee;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class EmployeeController {
    List<Employee> employeeList = new ArrayList<>();

    @PostMapping("api/register/employee")
    public ResponseEntity<String> registerEmployee(@RequestBody @Valid Employee inputEmployee) {
        inputEmployee.setUuid(UUID.randomUUID());
        employeeList.add(inputEmployee);
        return ResponseEntity.ok("Employee was added successfully! ID " + inputEmployee.getUuid());
    }

    @GetMapping("api/empoyees/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("api/employee/{uuid}")
    public ResponseEntity<Employee> getEmployee(@PathVariable UUID uuid) {
        return ResponseEntity.ok(employeeList.stream()
                .filter(e -> e.getUuid().equals(uuid))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @DeleteMapping("api/employee/{uuid}")
    public ResponseEntity<String> deleteEmployee(@PathVariable UUID uuid) {
        Optional<Employee> emp = employeeList.stream()
                .filter(e -> e.getUuid().equals(uuid))
                .findFirst();
        if (emp.isEmpty())
            return ResponseEntity.notFound().build();
        employeeList.remove(emp);
        return ResponseEntity.ok("Employee with ID: " + uuid + "was successully deleted!");
    }
}
