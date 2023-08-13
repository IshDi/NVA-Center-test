package dinara.cards;

public class CreditCard1proc_0_5proc_5cash extends CreditCard{
    // бонусные баллы 1% от покупки
    // бонусные баллы 5% при покупке более 5 000 руб.
    private int point = 0;

    // накоплени€ 0,5% при пополнении денег на собственные средства
    // за пополнение кредитного лимита баллы не начисл€ютс€
    private int saving = 0;


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
                setSaving(getSaving() + (int)(total * 0.005));
                return true;
            }
        }
        setBalance(getBalance() + sum);
        setSaving(getSaving() + (int)(sum * 0.005));
        return true;
    }

    @Override
    public boolean pay(int sum) {
        if (getBalance() == 0) {
            if (getCreditLimit() == 0 || getCreditLimit() < sum) {
                System.out.println("Ќедостаточно средств, пополните на: " + numberFormat.format(sum - getCreditLimit()));
                return false;
            }
            setCreditLimit(getCreditLimit() - sum);
            setPoint(getPoint() + calcPoint(sum));
            return true;
        }
        if (getBalance() < sum) {
            int total = sum - getBalance();
            if (getCreditLimit() == 0 || getCreditLimit() < total) {
                System.out.println("Ќедостаточно средств, пополните на: " + numberFormat.format(total - getCreditLimit()));
                return false;
            }
            setBalance(0);
            setCreditLimit(getCreditLimit() - total);
            setPoint(getPoint() + calcPoint(sum));
            return true;
        }
        setBalance(getBalance() - sum);
        setPoint(getPoint() + calcPoint(sum));
        return true;
    }

    @Override
    public void informationAboutAvailableFunds() {
        System.out.println(" редитные средства: " + numberFormat.format(getCreditLimit()));
        System.out.println("—обственные средства: " + numberFormat.format(getBalance()));
        System.out.println("Ѕонусные баллы: " + numberFormat.format(getPoint()));
        System.out.println("Ќакоплени€ от пополнений: " + numberFormat.format(getSaving()));
    }

    public int calcPoint(int sum) {
        if (sum >= 5000) {
            return (int)(sum * 0.05);
        }
        return (int)(sum * 0.01);
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getSaving() {
        return saving;
    }

    public void setSaving(int saving) {
        this.saving = saving;
    }
}
