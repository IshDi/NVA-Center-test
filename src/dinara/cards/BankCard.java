package dinara.cards;

public abstract class BankCard {
    private int balance;

    public abstract boolean replenish(int sum);

    public abstract boolean pay(int sum);

    public abstract void balanceInformation();

    public abstract void informationAboutAvailableFunds();

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
