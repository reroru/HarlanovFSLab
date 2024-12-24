package tech.reliab.course.harlanovf.service;

import tech.reliab.course.harlanovf.entity.Employee;
import tech.reliab.course.harlanovf.model.EmployeeRequest;

import java.time.LocalDate;
import java.util.List;


public interface EmployeeService {
    Employee createEmployee(EmployeeRequest employeeRequest);

    Employee getEmployee(int id);

    void deleteEmployee(int id);

    List<Employee> getAllEmployees();

}