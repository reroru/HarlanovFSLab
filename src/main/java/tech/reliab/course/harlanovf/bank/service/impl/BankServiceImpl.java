package tech.reliab.course.harlanovf.bank.service.impl;

import tech.reliab.course.harlanovf.bank.entity.*;
import tech.reliab.course.harlanovf.bank.service.BankService;


public class BankServiceImpl implements BankService {

    public Bank createBank(String name) {
        Bank bank = new Bank(name);
        bank.setRating(generateRandomRating());
        bank.setTotalMoney(generateRandomMoney());
        bank.setInterestRate(calculateInterestRate(bank.getRating()));
        return bank;
    }


    public void addOfficeToBank(Bank bank, BankOffice office) {
        bank.addOffice();

        office.setBank(bank);
    }


    public void addATMToBank(Bank bank, BankAtm atm) {
        bank.addAtm();

        atm.setBank(bank);
    }


    public void addEmployeeToBank(Bank bank, Employee employee) {
        bank.addEmployee();

        employee.setBank(bank);
        if (employee.getBankOffice().getBank() != bank)
            employee.setBankOffice(null);
    }


    public void addUserToBank(Bank bank, User user) {
        bank.addUser();

        //
    }


    public void removeOfficeFromBank(Bank bank, BankOffice office) {
        bank.removeOffice();

        office.setBank(null);
    }


    public void removeATMFromBank(Bank bank, BankAtm atm) {
        bank.removeAtm();

        atm.setBank(null);
    }


    public void removeEmployeeFromBank(Bank bank, Employee employee) {
        bank.removeEmployee();

        employee.setBank(null);
        if (employee.getBankOffice().getBank() == bank)
            employee.setBankOffice(null);
    }


    public void removeUserFromBank(Bank bank, User user) {
        bank.removeUser();

        //
    }

    private int generateRandomRating() {
        return (int) (Math.random() * 100);
    }

    private double generateRandomMoney() {
        return Math.random() * 1_000_000;
    }

    private double calculateInterestRate(int rating) {
        double baseRate = Math.random() * 20;
        return baseRate * (100 - rating) / 100;
    }
}