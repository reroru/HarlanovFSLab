package tech.reliab.course.harlanovf.service;

import tech.reliab.course.harlanovf.entity.Bank;

import java.util.List;

public interface BankService {
    Bank createBank(String name);

    Bank getBank(int id);

    void deleteBank(int id);

    List<Bank> getAllBanks();
}