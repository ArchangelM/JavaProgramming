package threads.atm;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RaceConditions {

    public static void main(String[] args) {
        Random random = new Random();

        ATM atm = new BadATM();

        long husbant = 1222;
        long wife = 1221;

        Set <Runnable> threads = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            threads.add(createWithdrawalThread(atm, wife, random.nextInt(1000)));
            threads.add(createWithdrawalThread(atm, husbant, random.nextInt(1000)));
        }

        for (Runnable thread: threads
                ) {

            new Thread(thread).start();
        }

        atm = new GoodATM();
        threads.clear();
        System.out.println();


        for (int i = 0; i < 5; i++) {
            threads.add(createWithdrawalThread(atm, wife, random.nextInt(1000)));
            threads.add(createWithdrawalThread(atm, husbant, random.nextInt(1000)));
        }

        for (Runnable thread: threads
                ) {

            new Thread(thread).start();
        }

        atm = new LegacyATM();
        threads.clear();
        System.out.println();


        for (int i = 0; i < 5; i++) {
            threads.add(createWithdrawalThread(atm, wife, random.nextInt(1000)));
            threads.add(createWithdrawalThread(atm, husbant, random.nextInt(1000)));
        }

        for (Runnable thread: threads
                ) {

            new Thread(thread).start();
        }

    }

    private static Runnable createWithdrawalThread(final ATM atm, final long accountID, final int ammount) {
        return new Runnable() {
            @Override
            public void run() {
                atm.checkBalance(accountID);
                atm.withdrawalMoney(accountID, ammount);
            }
        };
    }
}
