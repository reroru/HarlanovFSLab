package tech.reliab.course.harlanovf.bank.service.impl;

import tech.reliab.course.harlanovf.bank.entity.BankAtm;
import tech.reliab.course.harlanovf.bank.entity.Bank;
import tech.reliab.course.harlanovf.bank.entity.BankOffice;
import tech.reliab.course.harlanovf.bank.entity.Employee;
import tech.reliab.course.harlanovf.bank.service.BankAtmService;


public class BankAtmServiceImpl implements BankAtmService {

    public BankAtm createAtm(String name, Bank bank, BankOffice office, Employee servicingEmployee, boolean canDispenseCash, boolean canDepositCash, double amountOfMoney, double maintenanceCost) {
        BankAtm atm = new BankAtm(name, office.getAddress(), bank, office, servicingEmployee, canDispenseCash, canDepositCash, amountOfMoney, maintenanceCost);
        atm.setStatus(determineStatus(atm)); // Установка статуса
        return atm;
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