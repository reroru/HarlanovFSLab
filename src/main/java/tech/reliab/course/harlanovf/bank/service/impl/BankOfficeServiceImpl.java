package tech.reliab.course.harlanovf.bank.service.impl;

import tech.reliab.course.harlanovf.bank.entity.BankAtm;
import tech.reliab.course.harlanovf.bank.entity.Bank;
import tech.reliab.course.harlanovf.bank.entity.BankOffice;
import tech.reliab.course.harlanovf.bank.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {
    public BankOffice createOffice(String name, String address, Bank bank, boolean canPlaceAtm, boolean canOfferLoan, boolean canDispenseCash, boolean canDepositCash, double amountOfMoney, double rentCost) {
        BankOffice office = new BankOffice(name, address, bank, canPlaceAtm, canOfferLoan, canDispenseCash, canDepositCash, amountOfMoney, rentCost);
        return office;
    }

    public void updateOffice(BankOffice office) {
        office.setStatus(determineStatus(office));
        office.setCanOfferLoan(office.getStatus() == "WORKING");
        office.setCanDispenseCash(office.getStatus() == "WORKING");
        office.setCanDepositCash(office.getStatus() != "NOT_WORKING");
    }

    public void addAtmToOffice(BankOffice office, BankAtm atm) {
        if (office.isCanPlaceAtm() && office.getBank() == atm.getBank()) {
            office.addATM();
            updateOffice(office);

            atm.setOffice(office);
        }
    }

    public void removeAtmFromOffice(BankOffice office, BankAtm atm) {
        office.removeAtm();
        updateOffice(office);

        atm.setOffice(null);
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