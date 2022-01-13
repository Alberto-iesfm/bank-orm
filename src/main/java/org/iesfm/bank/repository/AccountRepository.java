package org.iesfm.bank.repository;

import org.iesfm.bank.pojos.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository <Account, String> {
    int deleteByIban (String iban);

    Optional<Account> findByIban (String iban);

    @Query(value = "SELECT a.* FROM Account a INNER JOIN Customer c ON c.id=a.owner_id WHERE c.nif=?", nativeQuery = true)
    List<Account> findByNif (String customerNif);

}
