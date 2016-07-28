package threads.atm;

public class GoodATM implements ATM {
    @Override
    public void checkBalance(long accountID) {
        System.out.println(accountID + " going to check balance.");
    }

    @Override
    public synchronized void withdrawalMoney(long accountID, int sum) {
        if(allowWidthrawalMoney(accountID, sum)) {
            updateBalance(accountID, sum, TransactionType.WIDTHRAWAL);
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
