package tech.reliab.course.harlanovf.bank.service;

import tech.reliab.course.harlanovf.bank.entity.Bank;
import tech.reliab.course.harlanovf.bank.entity.PaymentAccount;
import tech.reliab.course.harlanovf.bank.entity.User;

public interface PaymentAccountService {
    PaymentAccount createPaymentAccount(User user, Bank bank);

    void deposit(PaymentAccount account, double amount);

    boolean withdraw(PaymentAccount account, double amount);

    PaymentAccount getPaymentAccount(Long id);
}