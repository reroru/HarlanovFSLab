package tech.reliab.course.harlanovf.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.harlanovf.entity.CreditAccount;
import java.util.Optional;
public interface CreditAccountRepository extends JpaRepository<CreditAccount, Integer> {
    Optional<CreditAccount> findById(int id);
    void deleteById(int id);
}