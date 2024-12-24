package tech.reliab.course.harlanovf.bank.service.impl;

import tech.reliab.course.harlanovf.bank.entity.CreditAccount;
import tech.reliab.course.harlanovf.bank.entity.PaymentAccount;
import tech.reliab.course.harlanovf.bank.entity.User;
import tech.reliab.course.harlanovf.bank.entity.Bank;
import tech.reliab.course.harlanovf.bank.service.UserService;

import java.time.LocalDate;
import java.util.Random;


public class UserServiceImpl implements UserService {
    private Random random = new Random();

    public User createUser(String fullName, LocalDate dateOfBirth, String workplace) {
        double monthlyIncome = generateRandomIncome(); // Генерация случайного дохода
        int creditScore = calculateCreditScore(monthlyIncome); // Расчет кредитного рейтинга
        User user = new User(fullName, dateOfBirth, workplace, monthlyIncome, creditScore);
        return user;
    }


    private double generateRandomIncome() {
        return random.nextDouble() * 10000; // Генерация случайного дохода до 10 000
    }


    private int calculateCreditScore(double income) {
        if (income < 1000) {
            return 100;
        } else if (income < 2000) {
            return 200;
        } else if (income < 3000) {
            return 300;
        } else if (income < 4000) {
            return 400;
        } else if (income < 5000) {
            return 500;
        } else if (income < 6000) {
            return 600;
        } else if (income < 7000) {
            return 700;
        } else if (income < 8000) {
            return 800;
        } else if (income < 9000) {
            return 900;
        } else {
            return 1000; // Для дохода 10 000
        }
    }


    public void addBankToUser(User user, Bank bank) {

    }


    public void addCreditAccountToUser(User user, CreditAccount creditAccount) {

    }


    public void addPaymentAccountToUser(User user, PaymentAccount paymentAccount) {

    }


    public void deleteBankFromUser(User user, Bank bank) {

    }


    public void deleteCreditAccountFromUser(User user, CreditAccount creditAccount) {
    }


    public void deletePaymentAccountToUser(User user, PaymentAccount paymentAccount) {

    }
}