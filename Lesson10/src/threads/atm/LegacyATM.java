package threads.atm;


public class LegacyATM implements ATM {
    @Override
    public void checkBalance(long accountID) {
        System.out.println(accountID + " going to check balance.");
    }

    @Override
    public void withdrawalMoney(long accountID, int sum) {

        synchronized (this) {
            if(allowWidthrawalMoney(accountID, sum)) {
                updateBalance(accountID, sum, GoodATM.TransactionType.WIDTHRAWAL);
            }
        }

    }

    public void updateBalance(long accountID, int amount, GoodATM.TransactionType type) {
        System.out.println("Success " + type + " account " + accountID + " amount: " + amount);
    }

    private boolean allowWidthrawalMoney(long accountID, int amount) {
        return true;
    }

    enum TransactionType {
        DEPOSITE, WIDTHRAWAL;
    }
}
