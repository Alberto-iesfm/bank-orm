package org.iesfm.bank.controllers;

import org.iesfm.bank.pojos.Account;
import org.iesfm.bank.pojos.Customer;
import org.iesfm.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/accounts")
    public List<Account> list() {
        return accountRepository.findAll();
    }

    @Transactional
    @RequestMapping(method = RequestMethod.DELETE, path = "/accounts/{iban}")
    public void delete(@PathVariable(name = "iban") String iban) {
        if (accountRepository.deleteByIban(iban) == 0){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "La cuenta no existe"
            );
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/accounts/{iban}")
    public Account getCustomer(@PathVariable(name = "iban") String iban) {
        Optional<Account> customer = accountRepository.findByIban(iban);

        return customer.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "La cuanta no existe")
        );
    }
}
