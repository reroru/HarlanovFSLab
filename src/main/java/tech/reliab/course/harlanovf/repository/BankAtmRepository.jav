package tech.reliab.course.harlanovf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.harlanovf.entity.BankAtm;

import java.util.List;
import java.util.Optional;

public interface BankAtmRepository extends JpaRepository<BankAtm, Integer> {
    Optional<BankAtm> findById(int id);

    List<BankAtm> findAllByBankId(int id);

    void deleteById(int id);
}