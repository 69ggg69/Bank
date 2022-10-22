package com.Bank1;

import com.Bank1.domain.BankAccount;
import java.util.List;
public interface Work {
    BankAccount find(long id);
    void delete(BankAccount bankAccount);
    List<BankAccount> list();
}
