package tech.reliab.course.harlanovf.bank.service.impl;

import tech.reliab.course.harlanovf.bank.entity.*;
import tech.reliab.course.harlanovf.bank.service.CreditAccountService;

import java.time.LocalDate;
import java.time.Period;


public class CreditAccountServiceImpl implements CreditAccountService {
    public CreditAccount createCreditAccount(User user, Bank bank, LocalDate startDate, LocalDate endDate, double loanAmount, double monthlyPayment, double interestRate, Employee issuingEmployee, PaymentAccount paymentAccount) {
        Period period = Period.between(startDate, endDate);
        int numberOfMonths = period.getYears() * 12 + period.getMonths();

        CreditAccount creditAccount = new CreditAccount(user, bank, startDate, endDate, numberOfMonths, loanAmount, monthlyPayment, interestRate, issuingEmployee, paymentAccount);
        return creditAccount;
    }
}