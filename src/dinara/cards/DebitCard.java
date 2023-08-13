package dinara.cards;

import java.text.NumberFormat;

public class DebitCard extends BankCard {
    NumberFormat numberFormat = NumberFormat.getInstance();
    @Override
    public boolean replenish(int sum) {
        int newBalance = getBalance() + sum;
        setBalance(newBalance);
        return true;
    }

    @Override
    public boolean pay(int sum) {
        if (getBalance() < sum) {
            System.out.println("Недостаточно средств, пополните на: " + numberFormat.format(sum - getBalance()));
            return false;
        }
        int newBalance = getBalance() - sum;
        setBalance(newBalance);
        return true;
    }

    @Override
    public void balanceInformation() {
        System.out.println("Текущий баланс: " + numberFormat.format(getBalance()));
    }

    @Override
    public void informationAboutAvailableFunds() {
        System.out.println("Текущий баланс: " + numberFormat.format(getBalance()));
    }
}
