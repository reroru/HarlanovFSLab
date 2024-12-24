package tech.reliab.course.harlanovf.bank.service.impl;

import tech.reliab.course.harlanovf.bank.entity.BankAtm;
import tech.reliab.course.harlanovf.bank.entity.Bank;
import tech.reliab.course.harlanovf.bank.entity.BankOffice;
import tech.reliab.course.harlanovf.bank.entity.Employee;
import tech.reliab.course.harlanovf.bank.service.BankAtmService;
import tech.reliab.course.harlanovf.bank.service.BankOfficeService;

import java.util.HashMap;
import java.util.Map;


public class BankAtmServiceImpl implements BankAtmService {
    private final Map<Long, BankAtm> atmsTable = new HashMap<>();
    private final BankOfficeService bankOfficeService;

    public BankAtmServiceImpl(BankOfficeService bankOfficeService) {
        this.bankOfficeService = bankOfficeService;
    }

    public BankAtm createAtm(String name, Bank bank, BankOffice office, Employee servicingEmployee, boolean canDispenseCash, boolean canDepositCash, double amountOfMoney, double maintenanceCost) {
        BankAtm atm = new BankAtm(name, office.getAddress(), bank, office, servicingEmployee, canDispenseCash, canDepositCash, amountOfMoney, maintenanceCost);
        atmsTable.put(atm.getId(), atm);
        bankOfficeService.addAtm(atm.getOffice().getId(), atm);
        return atm;
    }

    public BankAtm getAtm(Long id) {
        return atmsTable.get(id);
    }

    public void updateAtm(BankAtm atm) {
        atm.setStatus(determineStatus(atm));
        atm.setCanDispenseCash(atm.getStatus() == "WORKING");
        atm.setCanDepositCash(atm.getStatus() != "NOT_WORKING");
        atm.setAddress(atm.getOffice().getAddress());
    }

    private String determineStatus(BankAtm atm) {
        if (atm.getAmountOfMoney() <= 0) {
            return "OUT_OF_MONEY";
        }
        return "WORKING";
    }

    public void updateAmountOfMoney(BankAtm atm, double amount) {
        atm.setAmountOfMoney(amount);
        updateAtm(atm);
    }
}