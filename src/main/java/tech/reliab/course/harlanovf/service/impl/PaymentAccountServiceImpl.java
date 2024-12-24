package tech.reliab.course.harlanovf.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.harlanovf.entity.PaymentAccount;
import tech.reliab.course.harlanovf.model.PaymentAccountRequest;
import tech.reliab.course.harlanovf.repository.PaymentAccountRepository;
import tech.reliab.course.harlanovf.service.BankService;
import tech.reliab.course.harlanovf.service.PaymentAccountService;
import tech.reliab.course.harlanovf.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PaymentAccountServiceImpl implements PaymentAccountService {
    private final PaymentAccountRepository paymentAccountRepository;
    private final UserService userService;
    private final BankService bankService;


    public PaymentAccount createPaymentAccount(PaymentAccountRequest paymentAccountRequest) {
        PaymentAccount paymentAccount = new PaymentAccount(userService.getUser(paymentAccountRequest.getUserId()),
                bankService.getBank(paymentAccountRequest.getBankId()));
        return paymentAccountRepository.save(paymentAccount);
    }

    public PaymentAccount getPaymentAccount(int id) {
        return paymentAccountRepository.findById(id).orElseThrow(() -> new NoSuchElementException("PaymentAccount was not found"));
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

    public List<PaymentAccount> getAllPaymentAccounts() {
        return paymentAccountRepository.findAll();
    }

    public void deletePaymentAccount(int id) {
        paymentAccountRepository.deleteById(id);
    }
}