package tech.reliab.course.harlanovf.service;

import tech.reliab.course.harlanovf.entity.CreditAccount;
import tech.reliab.course.harlanovf.model.CreditAccountRequest;

import java.util.List;

public interface CreditAccountService {
    CreditAccount createCreditAccount(CreditAccountRequest creditAccountRequest);

    CreditAccount getCreditAccount(int id);

    void deleteCreditAccount(int id);

    List<CreditAccount> getAllCreditAccounts();
}

