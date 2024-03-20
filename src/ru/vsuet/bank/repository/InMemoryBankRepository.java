package ru.vsuet.bank.repository;

import ru.vsuet.bank.domain.BankAccount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InMemoryBankRepository implements Repository<BankAccount> {
    private static InMemoryBankRepository instance;
    public static InMemoryBankRepository getInstance() {
        if (instance == null) {
            instance = new InMemoryBankRepository();
        }
        return instance;
    }

    private List<BankAccount> accounts;

    private InMemoryBankRepository() {
        accounts = new ArrayList<>();
        init();
    }

    @Override
    public void save(BankAccount source) {
        accounts.add(source);
    }

    @Override
    public void delete(BankAccount target) {
        accounts.remove(target);
    }

    @Override
    public List<BankAccount> list() {
        return new ArrayList<>(accounts);
    }

    @Override
    public BankAccount find(Long id) {
        return accounts.stream().filter(account -> account.getId().equals(id)).findFirst().orElse(null);
    }

    private void init() {

    }
     public List<BankAccount> getAccounts() {
        return accounts;
    }
    }
