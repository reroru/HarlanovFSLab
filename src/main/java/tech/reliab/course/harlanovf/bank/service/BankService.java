package tech.reliab.course.harlanovf.bank.service;

import tech.reliab.course.harlanovf.bank.entity.*;

public interface BankService {
    Bank createBank(String name);

    void addOfficeToBank(Bank bank, BankOffice office);

    void addATMToBank(Bank bank, BankAtm atm);

    void addEmployeeToBank(Bank bank, Employee employee);

    void addUserToBank(Bank bank, User user);
}