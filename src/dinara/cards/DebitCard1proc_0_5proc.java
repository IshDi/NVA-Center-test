package dinara.cards;

public class DebitCard1proc_0_5proc extends DebitCard1proc{
    private int saving = 0;
    // ���������� 0,5% ��� ����������
    @Override
    public boolean replenish(int sum) {
        int newBalance = getBalance() + sum;
        setBalance(newBalance);
        setSaving(getSaving() + (int)(sum * 0.005));
        return true;
    }
    @Override
    public void informationAboutAvailableFunds() {
        System.out.println("������� ������: " + numberFormat.format(getBalance()));
        System.out.println("�������� �����: " + numberFormat.format(getPoint()));
        System.out.println("���������� �� ����������: " + numberFormat.format(getSaving()));
    }

    public int getSaving() {
        return saving;
    }

    public void setSaving(int saving) {
        this.saving = saving;
    }
}
