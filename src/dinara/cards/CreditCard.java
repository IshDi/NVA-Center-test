package dinara.cards;

import java.text.NumberFormat;

public class CreditCard extends BankCard {
    private int creditLimit;

    private Integer LIMIT;

    NumberFormat numberFormat = NumberFormat.getInstance();
    @Override
    public boolean replenish(int sum) {
        if (getCreditLimit() < getLIMIT()) {
            if ((getCreditLimit() + sum)  < getLIMIT()) {
                setCreditLimit(getCreditLimit() + sum);
                return true;
            }
            if ((getCreditLimit() + sum)  == getLIMIT()) {
                setCreditLimit(getCreditLimit() + sum);
                return true;
            }
            if ((getCreditLimit() + sum)  > getLIMIT()) {
                int total = sum - (getLIMIT() - getCreditLimit());
                setCreditLimit(getLIMIT());
                setBalance(total);
                return true;
            }
        }
        setBalance(getBalance() + sum);
        return true;
    }

    @Override
    public boolean pay(int sum) {
        if (getBalance() == 0) {
            if (getCreditLimit() == 0 || getCreditLimit() < sum) {
                System.out.println("Недостаточно средств, пополните на: " + numberFormat.format(sum - getCreditLimit()));
                return false;
            }
            setCreditLimit(getCreditLimit() - sum);
            return true;
        }
        if (getBalance() < sum) {
            int total = sum - getBalance();
            if (getCreditLimit() == 0 || getCreditLimit() < total) {
                System.out.println("Недостаточно средств, пополните на: " + numberFormat.format(total - getCreditLimit()));
                return false;
            }
            setBalance(0);
            setCreditLimit(getCreditLimit() - total);
            return true;
        }
        setBalance(getBalance() - sum);
        return true;
    }

    @Override
    public void balanceInformation() {
        System.out.println("Кредитные средства: " + numberFormat.format(getCreditLimit()));
        System.out.println("Собственные средства: " + numberFormat.format(getBalance()));
    }

    @Override
    public void informationAboutAvailableFunds() {
        System.out.println("Кредитные средства: " + numberFormat.format(getCreditLimit()));
        System.out.println("Собственные средства: " + numberFormat.format(getBalance()));
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        if (LIMIT == null) {
            setLIMIT(creditLimit);
        }
        this.creditLimit = creditLimit;
    }

    public Integer getLIMIT() {
        return LIMIT;
    }

    public void setLIMIT(Integer LIMIT) {
        this.LIMIT = LIMIT;
    }
}
