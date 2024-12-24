package tech.reliab.course.harlanovf.bank.service;

import tech.reliab.course.harlanovf.bank.entity.*;

import java.time.LocalDate;

public interface CreditAccountService {
    CreditAccount createCreditAccount(User user, Bank bank, LocalDate startDate, LocalDate endDate, double loanAmount, double monthlyPayment, double interestRate, Employee issuingEmployee, PaymentAccount paymentAccount);
}

