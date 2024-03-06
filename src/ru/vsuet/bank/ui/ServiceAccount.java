package ru.vsuet.bank.ui;

import ru.vsuet.bank.domain.AddMoney;
import ru.vsuet.bank.domain.BankAccount;
import ru.vsuet.bank.domain.MinMoney;
import ru.vsuet.bank.domain.Transfer;
import ru.vsuet.bank.repository.Repository;

import java.math.BigDecimal;
import java.util.List;

public class ServiceAccount implements Service<BankAccount>{
    private final Repository<BankAccount> repository;

    public ServiceAccount(Repository<BankAccount> repository) {
        this.repository = repository;
    }
    @Override
    public void transfer(Long sourceId, Long targetId, BigDecimal amount) {
        BankAccount sourceAccount = repository.find(sourceId);
        BankAccount targetAccount = repository.find(targetId);
        Transfer transferCommand = new Transfer(sourceAccount, targetAccount, amount);
        transferCommand.execute();
        repository.save(sourceAccount);
        repository.save(targetAccount);
    }

    @Override
    public List<BankAccount> getAll() {
        return repository.list();

    }

    @Override
    public void addMoney(Long source, BigDecimal amount) {
        BankAccount sourceAccount = repository.find(source);
        AddMoney addMoneyCommand = new AddMoney(sourceAccount, amount);
        addMoneyCommand.execute();
        repository.save(sourceAccount);
    }

    @Override
    public void minMoney(Long source, BigDecimal amount) {
        BankAccount sourceAccount = repository.find(source);
        MinMoney minMoneyCommand = new MinMoney(sourceAccount, amount);
        minMoneyCommand.execute();
        repository.save(sourceAccount);
    }

    @Override
    public BankAccount findCom(Long id) {
        return repository.find(id);
    }

    @Override
    public void deleteCom(BankAccount target) {
        repository.delete(target);
    }

    @Override
    public void addCom(BankAccount source) {
        repository.save(source);
    }
}