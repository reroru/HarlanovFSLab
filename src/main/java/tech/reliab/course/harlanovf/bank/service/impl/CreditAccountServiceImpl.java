package tech.reliab.course.harlanovf.bank.service.impl;

import tech.reliab.course.harlanovf.bank.entity.*;
import tech.reliab.course.harlanovf.bank.service.CreditAccountService;
import tech.reliab.course.harlanovf.bank.service.UserService;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

public class CreditAccountServiceImpl implements CreditAccountService {
    private final Map<Long, CreditAccount> creditAccountsTable = new HashMap<>();
    private final UserService userService;

    public CreditAccountServiceImpl(UserService userService) {
        this.userService = userService;
    }

    public CreditAccount createCreditAccount(User user, Bank bank, LocalDate startDate, LocalDate endDate, double loanAmount, double monthlyPayment, double interestRate, Employee issuingEmployee, PaymentAccount paymentAccount) {
        Period period = Period.between(startDate, endDate);
        int numberOfMonths = period.getYears() * 12 + period.getMonths();

        CreditAccount creditAccount = new CreditAccount(user, bank, startDate, endDate, numberOfMonths, loanAmount, monthlyPayment, interestRate, issuingEmployee, paymentAccount);
        creditAccountsTable.put(creditAccount.getId(), creditAccount);
        userService.addCreditAccount(creditAccount.getUser().getId(), creditAccount);
        return creditAccount;
    }

    public CreditAccount getCreditAccountById(Long id) {
        return creditAccountsTable.get(id);
    }
}