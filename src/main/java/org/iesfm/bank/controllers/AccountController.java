package org.iesfm.bank.controllers;

import org.iesfm.bank.pojos.Account;
import org.iesfm.bank.pojos.Customer;
import org.iesfm.bank.repository.AccountRepository;
import org.iesfm.bank.repository.CustomerRepository;
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
    @Autowired
    private CustomerRepository customerRepository;

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
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "La cuenta no existe")
        );
    }

    @RequestMapping(method = RequestMethod.POST, path = "/customers/{nif}/accounts")
    public void insertAccount (@PathVariable("nif") String nif, @RequestBody Account account){
        if (customerRepository.existsByNif(nif)){
            if (accountRepository.existsById(account.getIban())){
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT, "La cuenta ya existe"
                );
            } else {
                accountRepository.save(account);
            }
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "El cliente no existe"
            );
        }
    }
}
