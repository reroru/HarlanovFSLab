package tech.reliab.course.harlanovf.bank.service.impl;

import tech.reliab.course.harlanovf.bank.entity.Bank;
import tech.reliab.course.harlanovf.bank.entity.BankOffice;
import tech.reliab.course.harlanovf.bank.entity.Employee;
import tech.reliab.course.harlanovf.bank.service.BankOfficeService;
import tech.reliab.course.harlanovf.bank.service.EmployeeService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class EmployeeServiceImpl implements EmployeeService {
    private final Map<Long, Employee> employeesTable = new HashMap<>();
    private final BankOfficeService bankOfficeService;

    public EmployeeServiceImpl(BankOfficeService bankOfficeService) {
        this.bankOfficeService = bankOfficeService;

    public Employee createEmployee(String fullName, LocalDate dateOfBirth, String position, Bank bank, double salary, boolean canIssueLoans, BankOffice bankOffice) {
        Employee employee = new Employee(fullName, dateOfBirth, position, bank, salary, canIssueLoans, bankOffice);

        employeesTable.put(employee.getId(), employee);
        bankOfficeService.addEmployee(employee.getBankOffice().getId(), employee);

        return employee;
    }

    public Employee createEmployee(String fullName, LocalDate dateOfBirth, String position, Bank bank, double salary, boolean canIssueLoans) {
        Employee employee = new Employee(fullName, dateOfBirth, position, bank, salary, canIssueLoans);

        employeesTable.put(employee.getId(), employee);
        bankOfficeService.addEmployee(employee.getBankOffice().getId(), employee);

        return employee;
    }

    public Employee getEmployee(Long id) {
        Employee employee = employeesTable.get(id);
        return employeesTable.get(id);
    }
}