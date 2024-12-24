package tech.reliab.course.harlanovf.bank.service.impl;

import tech.reliab.course.harlanovf.bank.entity.Bank;
import tech.reliab.course.harlanovf.bank.entity.PaymentAccount;
import tech.reliab.course.harlanovf.bank.entity.User;
import tech.reliab.course.harlanovf.bank.service.PaymentAccountService;
import tech.reliab.course.harlanovf.bank.service.UserService;

import java.util.HashMap;
import java.util.Map;


public class PaymentAccountServiceImpl implements PaymentAccountService {
    private final Map<Long, PaymentAccount> paymentAccountsTable = new HashMap<>();
    private final UserService userService;

    public PaymentAccountServiceImpl(UserService userService) {
        this.userService = userService;
    }

    public PaymentAccount createPaymentAccount(User user, Bank bank) {
        PaymentAccount account = new PaymentAccount(user, bank);
        paymentAccountsTable.put(account.getId(), account);
        userService.addPaymentAccount(account.getUser().getId(), account);

        return account;
    }

    public PaymentAccount getPaymentAccount(Long id) {
        return paymentAccountsTable.get(id);
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