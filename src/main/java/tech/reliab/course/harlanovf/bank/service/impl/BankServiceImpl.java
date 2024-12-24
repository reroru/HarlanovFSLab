package tech.reliab.course.harlanovf.bank.service.impl;

import tech.reliab.course.harlanovf.bank.entity.*;
import tech.reliab.course.harlanovf.bank.service.BankOfficeService;
import tech.reliab.course.harlanovf.bank.service.BankService;
import tech.reliab.course.harlanovf.bank.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class BankServiceImpl implements BankService {
    private final Map<Long, Bank> banksTable = new HashMap<>();
    private final Map<Long, List<BankOffice>> officesByBankIdTable = new HashMap<>();
    private final Map<Long, List<User>> usersByBankIdTable = new HashMap<>();
    private BankOfficeService bankOfficeService;
    private UserService clientService;

    public Bank createBank(String name) {
        Bank bank = new Bank(name);
        bank.setRating(generateRandomRating());
        bank.setTotalMoney(generateRandomMoney());
        bank.setInterestRate(calculateInterestRate(bank.getRating()));

        banksTable.put(bank.getId(), bank);
        officesByBankIdTable.put(bank.getId(), new ArrayList<>());
        usersByBankIdTable.put(bank.getId(), new ArrayList<>());

        return bank;
    }

    public Bank getBank(Long id) {
        return banksTable.get(id);
    }

    public void deleteBank(Long id) {
        banksTable.remove(id);
    }

    public void addOffice(Long bankId, BankOffice office) {
        Bank bank = getBank(bankId);

        office.setBank(bank);
        bank.addOffice();
        bank.setNumberOfATMs(bank.getNumberOfATMs() + office.getNumberOfATMs());
        bank.setTotalMoney(bank.getTotalMoney() + office.getAmountOfMoney());

        List<BankOffice> bankOffices = officesByBankIdTable.get(bankId);
        bankOffices.add(office);
    }

    public void addEmployee(Long bankId, Employee employee) {
        Bank bank = getBank(bankId);

        bank.addEmployee();

        employee.setBank(bank);
        if (employee.getBankOffice().getBank() != bank)
            employee.setBankOffice(null);
    }

    public void addUser(Long bankId, User user) {
        Bank bank = getBank(bankId);

        user.setBank(bank);
        bank.addUser();
        List<User> users = usersByBankIdTable.get(bankId);
        users.add(user);
    }

    public void deleteOffice(Long bankId, BankOffice office) {
        Bank bank = getBank(bankId);
        office.setBank(null);

        int officeIndex = officesByBankIdTable.get(bankId).indexOf(office);
        bank.removeOffice();
        bank.setNumberOfATMs(bank.getNumberOfATMs() - officesByBankIdTable.get(bankId).get(officeIndex).getNumberOfATMs());
        officesByBankIdTable.get(bankId).remove(officeIndex);
    }

    public void deleteEmployee(Bank bank, Employee employee) {
        bank.removeEmployee();

        employee.setBank(null);
        if (employee.getBankOffice().getBank() == bank)
            bankOfficeService.deleteEmployee(employee.getBankOffice().getId(), employee);
    }

    public void deleteUser(Long bankId, User user) {
        Bank bank = getBank(bankId);
        user.setBank(null);

        usersByBankIdTable.get(bankId).remove(user);

        bank.removeUser();
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