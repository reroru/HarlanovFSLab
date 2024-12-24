package tech.reliab.course.harlanovf.bank.service.impl;

import tech.reliab.course.harlanovf.bank.entity.Bank;
import tech.reliab.course.harlanovf.bank.entity.PaymentAccount;
import tech.reliab.course.harlanovf.bank.entity.User;
import tech.reliab.course.harlanovf.bank.service.PaymentAccountService;


public class PaymentAccountServiceImpl implements PaymentAccountService {

    public PaymentAccount createPaymentAccount(User user, Bank bank) {
        PaymentAccount account = new PaymentAccount(user, bank);
        return account;
    }


    public void deposit(PaymentAccount account, double amount) {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
        }
    }


    public boolean withdraw(PaymentAccount account, double amount) {
        if (amount > 0 && amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            return true;
        }
        return false; // Неудачное снятие
    }
}