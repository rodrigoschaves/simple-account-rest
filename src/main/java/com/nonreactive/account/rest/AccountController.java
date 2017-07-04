package com.nonreactive.account.rest;

import com.nonreactive.account.domain.entities.Account;
import com.nonreactive.account.domain.enums.Currency;
import com.nonreactive.account.domain.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rodrigo.chaves on 20/06/2017.
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "/currency/{currency}", method = RequestMethod.GET)
    List<Account> findByCurrency(@PathVariable String currency) {
        return accountRepository.findByCurrency(Currency.fromValue(currency));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Account findById(@PathVariable String id) {
        return accountRepository.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Account save(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    @RequestMapping(value = "/batch", method = RequestMethod.POST)
    List<Account> saveAll(@RequestBody List<Account> accounts) {
        return accountRepository.save(accounts);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Account> findAll() {
        return accountRepository.findAll();
    }

}
