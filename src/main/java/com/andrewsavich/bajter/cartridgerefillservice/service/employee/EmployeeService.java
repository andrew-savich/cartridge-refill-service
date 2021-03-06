package com.andrewsavich.bajter.cartridgerefillservice.service.employee;

import com.andrewsavich.bajter.cartridgerefillservice.model.employee.Employee;
import com.andrewsavich.bajter.cartridgerefillservice.model.employee.Position;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee getEmployeeById(Long id);

    void saveEmployee(Employee employee);

    void deleteEmployeeById(Long id);

    List<Position> getAllEmployeePositions();
}
