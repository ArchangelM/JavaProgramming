package threads.atm;


public interface ATM {
    public void checkBalance(long accountID);
    public void withdrawalMoney(long accountID, int sum);

}
