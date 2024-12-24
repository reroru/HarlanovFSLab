package tech.reliab.course.harlanovf.service;

import tech.reliab.course.harlanovf.entity.BankAtm;
import tech.reliab.course.harlanovf.model.BankAtmRequest;

import java.util.List;


public interface BankAtmService {
    BankAtm createBankAtm(BankAtmRequest bankAtmRequest);

    BankAtm getAtm(int id);

    BankAtm updateAtm(int id);

    void updateAmountOfMoney(BankAtm atm, double amount);

    void deleteAtm(int id);

    List<BankAtm> getAllBankAtms();

    List<BankAtm> getAllBankAtmsByBankId(int bankId);
}