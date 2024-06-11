package codetechtask.level3.task1;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    // Constructors, getters, and setters
    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        this.balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    public void withdraw(double amount) throws Exception {
        if (amount > this.balance) {
            throw new Exception("Insufficient funds");
        }
        this.balance -= amount;
        transactions.add(new Transaction("Withdraw", amount));
    }

    public void transfer(Account toAccount, double amount) throws Exception {
        if (amount > this.balance) {
            throw new Exception("Insufficient funds");
        }
        this.balance -= amount;
        toAccount.deposit(amount);
        transactions.add(new Transaction("Transfer to " + toAccount.getAccountNumber(), amount));
        toAccount.getTransactions().add(new Transaction("Transfer from " + this.accountNumber, amount));
    }
}
