package codetechtask.level3.task1;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private Map<String, Account> accounts = new HashMap<>();

    public Account createAccount(String accountNumber) {
        Account account = new Account(accountNumber);
        accounts.put(accountNumber, account);
        return account;
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
