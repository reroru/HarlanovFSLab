package tech.reliab.course.harlanovf.bank.service;

import tech.reliab.course.harlanovf.bank.entity.BankAtm;
import tech.reliab.course.harlanovf.bank.entity.Bank;
import tech.reliab.course.harlanovf.bank.entity.BankOffice;
import tech.reliab.course.harlanovf.bank.entity.Employee;


public interface BankAtmService {
    BankAtm createAtm(String name, Bank bank, BankOffice office, Employee servicingEmployee, boolean canDispenseCash, boolean canDepositCash, double amountOfMoney, double maintenanceCost);

    void updateAtm(BankAtm atm);

    void updateAmountOfMoney(BankAtm atm, double amount);
}