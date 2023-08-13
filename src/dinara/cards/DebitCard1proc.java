package dinara.cards;

public class DebitCard1proc extends DebitCard {
    private int point = 0;
    // бонусные баллы 1% от покупки

    @Override
    public boolean pay(int sum) {
        if (getBalance() < sum) {
            System.out.println("Недостаточно средств, пополните на: " + numberFormat.format(sum - getBalance()));
            return false;
        }
        int newBalance = getBalance() - sum;
        setBalance(newBalance);
        setPoint(getPoint() +(int)(sum * 0.01));
        return true;
    }

    @Override
    public void informationAboutAvailableFunds() {
        System.out.println("Текущий баланс: " + numberFormat.format(getBalance()));
        System.out.println("Бонусные баллы: " + numberFormat.format(getPoint()));
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
