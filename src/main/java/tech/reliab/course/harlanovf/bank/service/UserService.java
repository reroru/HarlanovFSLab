package tech.reliab.course.harlanovf.bank.service;

import tech.reliab.course.harlanovf.bank.entity.Bank;
import tech.reliab.course.harlanovf.bank.entity.CreditAccount;
import tech.reliab.course.harlanovf.bank.entity.PaymentAccount;
import tech.reliab.course.harlanovf.bank.entity.User;

import java.time.LocalDate;

public interface UserService {
    User createUser(String fullName, LocalDate dateOfBirth, String workplace);

    void addBankToUser(User user, Bank bank);

    void addCreditAccountToUser(User user, CreditAccount creditAccount);

    void addPaymentAccountToUser(User user, PaymentAccount paymentAccount);

    void deleteBankFromUser(User user, Bank bank);

    void deleteCreditAccountFromUser(User user, CreditAccount creditAccount);

    void deletePaymentAccountToUser(User user, PaymentAccount paymentAccount);
}