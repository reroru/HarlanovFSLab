package tech.reliab.course.harlanovf.bank.service.impl;

import tech.reliab.course.harlanovf.bank.entity.BankAtm;
import tech.reliab.course.harlanovf.bank.entity.Bank;
import tech.reliab.course.harlanovf.bank.entity.BankOffice;
import tech.reliab.course.harlanovf.bank.entity.Employee;
import tech.reliab.course.harlanovf.bank.service.BankOfficeService;
import tech.reliab.course.harlanovf.bank.service.BankService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankOfficeServiceImpl implements BankOfficeService {
    private final BankService bankService;
    private final Map<Long, BankOffice> bankOfficesTable = new HashMap<>();
    private final Map<Long, List<Employee>> employeesByOfficeIdTable = new HashMap<>();
    private final Map<Long, List<BankAtm>> atmsByOfficeIdTable = new HashMap<>();

    public BankOfficeServiceImpl(BankService bankService) {
        this.bankService = bankService;
    }

    public BankOffice createOffice(String name, String address, Bank bank, boolean canPlaceAtm, boolean canOfferLoan, boolean canDispenseCash, boolean canDepositCash, double amountOfMoney, double rentCost) {
        BankOffice office = new BankOffice(name, address, bank, canPlaceAtm, canOfferLoan, canDispenseCash, canDepositCash, amountOfMoney, rentCost);
        bankOfficesTable.put(office.getId(), office);
        employeesByOfficeIdTable.put(office.getId(), new ArrayList<>());
        atmsByOfficeIdTable.put(office.getId(), new ArrayList<>());
        bankService.addOffice(office.getBank().getId(), office);

        return office;
    }

    public BankOffice getOfficeById(Long id) {
        return bankOfficesTable.get(id);
    }


    public void updateOffice(BankOffice office) {
        office.setStatus(determineStatus(office));
        office.setCanOfferLoan(office.getStatus() == "WORKING");
        office.setCanDispenseCash(office.getStatus() == "WORKING");
        office.setCanDepositCash(office.getStatus() != "NOT_WORKING");
    }

    public void addAtm(Long officeId, BankAtm atm) {
        BankOffice office = getOfficeById(officeId);
        if (office.isCanPlaceAtm()) {
            office.addATM();
            office.getBank().addAtm();

            atm.setOffice(office);
            atm.setBank(office.getBank());
            atm.setAddress(office.getAddress());

            List<BankAtm> officeAtms = atmsByOfficeIdTable.get(office.getId());
            officeAtms.add(atm);
        }
    }

    public void deleteAtm(Long officeId, BankAtm atm) {
        BankOffice office = getOfficeById(officeId);
        int atmIndex = atmsByOfficeIdTable.get(officeId).indexOf(atm);
        office.getBank().removeAtm();
        office.removeAtm();
        atmsByOfficeIdTable.get(officeId).remove(atmIndex);

        atm.setOffice(null);
    }

    public void addEmployee(Long officeId, Employee employee) {
        BankOffice office = getOfficeById(officeId);
        office.addEmployee();

        employee.setBankOffice(office);
        employee.setBank(office.getBank());
        List<Employee> officeEmployees = employeesByOfficeIdTable.get(office.getId());
        officeEmployees.add(employee);
    }

    public void deleteEmployee(Long officeId, Employee employee) {
        BankOffice office = getOfficeById(officeId);
        int employeeIndex = employeesByOfficeIdTable.get(officeId).indexOf(employee);
        office.getBank().removeEmployee();
        office.removeEmployee();
        employeesByOfficeIdTable.get(officeId).remove(employeeIndex);

        employee.setBankOffice(null);
    }

    public void updateAmountOfMoney(BankOffice office, double amount) {
        double diff = amount - office.getAmountOfMoney();
        if (diff + office.getBank().getTotalMoney() >= 0) {
            office.setAmountOfMoney(amount);
            updateOffice(office);

            office.getBank().setTotalMoney(diff + office.getBank().getTotalMoney());
        }
    }

    private String determineStatus(BankOffice office) {
        if (office.getAmountOfMoney() <= 0) {
            return "OUT_OF_MONEY";
        }
        return "WORKING";
    }
}