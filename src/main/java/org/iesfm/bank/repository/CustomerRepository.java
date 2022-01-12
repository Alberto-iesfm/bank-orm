package org.iesfm.bank.repository;

import org.iesfm.bank.pojos.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Integer> {
    boolean existsByNif(String nif);

    int deleteByNif (String nif);

    Optional<Customer> findOneByNif (String nif);
}
