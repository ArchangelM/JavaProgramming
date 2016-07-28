package threads.atm;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BadATM implements ATM {

    private Lock accountLock;
    Account account;


    public BadATM() {
        accountLock = new ReentrantLock();
        account = new Account();
    }

    @Override
    public void checkBalance(long accountID) {
        System.out.println(accountID + " going to check balance.");

        //return account.getBalance(accountID);
    }

    @Override
    public void withdrawalMoney(long accountID, int sum) {
        accountLock.lock();

        try {
            if(allowWidthrawalMoney(accountID, sum)) {
                updateBalance(accountID, sum, TransactionType.WIDTHRAWAL);
            }
        } finally {
            accountLock.unlock();
        }

        //        if (account.getBalance(accountID) >= sum) {
//
//            //return sum;
//        }
//        //return 0;
    }

    private class Account {
        private Set<Long> accounts;
        private int balance;

        public Account(long accountID, int balance) {
            this.balance = balance;
            accounts = new HashSet<>();
            accounts.add(accountID);
        }

        public Account() {
        }

        public void addAccount(long accountID) {
            accounts.add(accountID);
        }

        public int getBalance(long accountID) {
            if (accounts.contains(accountID)) {
                return balance;
            }

            return 0;
        }

        public int addToBalance(long accountID, int sum) {
            if (accounts.contains(accountID)) {
                balance += sum;
                return sum;
            }

            return 0;
        }

        public int takeFromBalance(long accountID, int sum) {
            if (accounts.contains(accountID)) {
                balance -= sum;
                return sum;
            }

            return 0;
        }
    }

    public void updateBalance(long accountID, int amount, TransactionType type) {
        System.out.println("Success " + type + " account " + accountID + " amount: " + amount);
    }

    private boolean allowWidthrawalMoney(long accountID, int amount) {
        return true;
    }

    enum TransactionType {
        DEPOSITE, WIDTHRAWAL;
    }
}
