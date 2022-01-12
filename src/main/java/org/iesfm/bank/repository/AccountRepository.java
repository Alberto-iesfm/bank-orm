package org.iesfm.bank.repository;

import org.iesfm.bank.pojos.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository <Account, String> {
    int deleteByIban (String iban);

    Optional<Account> findByIban (String iban);

}
