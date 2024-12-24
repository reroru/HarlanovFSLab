package tech.reliab.course.harlanovf.service;

import tech.reliab.course.harlanovf.entity.PaymentAccount;
import tech.reliab.course.harlanovf.model.PaymentAccountRequest;

import java.util.List;

public interface PaymentAccountService {
    PaymentAccount createPaymentAccount(PaymentAccountRequest paymentAccountRequest);

    void deposit(PaymentAccount account, double amount);

    boolean withdraw(PaymentAccount account, double amount);

    PaymentAccount getPaymentAccount(int id);

    List<PaymentAccount> getAllPaymentAccounts();

    void deletePaymentAccount(int id);
}