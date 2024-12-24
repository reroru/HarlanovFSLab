package tech.reliab.course.harlanovf.service;

import tech.reliab.course.harlanovf.entity.BankOffice;
import tech.reliab.course.harlanovf.model.BankOfficeRequest;

import java.util.List;

public interface BankOfficeService {
    BankOffice createBankOffice(BankOfficeRequest bankOfficeRequest);

    BankOffice getOffice(int id);

    BankOffice updateOffice(int id);

    void updateAmountOfMoney(BankOffice office, double amount);

    void deleteOffice(int id);

    List<BankOffice> getAllBankOffices();
}