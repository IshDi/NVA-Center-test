package dinara.cards;

public class DebitCard1proc_0_5proc extends DebitCard1proc{
    private int saving = 0;
    // накопления 0,5% при пополнении
    @Override
    public boolean replenish(int sum) {
        int newBalance = getBalance() + sum;
        setBalance(newBalance);
        setSaving(getSaving() + (int)(sum * 0.005));
        return true;
    }
    @Override
    public void informationAboutAvailableFunds() {
        System.out.println("Текущий баланс: " + numberFormat.format(getBalance()));
        System.out.println("Бонусные баллы: " + numberFormat.format(getPoint()));
        System.out.println("Накопления от пополнений: " + numberFormat.format(getSaving()));
    }

    public int getSaving() {
        return saving;
    }

    public void setSaving(int saving) {
        this.saving = saving;
    }
}
