package tech.reliab.course.harlanovf.bank.service.impl;

import tech.reliab.course.harlanovf.bank.entity.Bank;
import tech.reliab.course.harlanovf.bank.entity.BankOffice;
import tech.reliab.course.harlanovf.bank.entity.Employee;
import tech.reliab.course.harlanovf.bank.service.EmployeeService;

import java.time.LocalDate;


public class EmployeeServiceImpl implements EmployeeService {
    public Employee createEmployee(String fullName, LocalDate dateOfBirth, String position, Bank bank, double salary, boolean canIssueLoans, BankOffice bankOffice) {
        Employee employee = new Employee(fullName, dateOfBirth, position, bank, salary, canIssueLoans, bankOffice);
        return employee;
    }


    public Employee createEmployee(String fullName, LocalDate dateOfBirth, String position, Bank bank, double salary, boolean canIssueLoans) {
        Employee employee = new Employee(fullName, dateOfBirth, position, bank, salary, canIssueLoans);
        return employee;
    }
}