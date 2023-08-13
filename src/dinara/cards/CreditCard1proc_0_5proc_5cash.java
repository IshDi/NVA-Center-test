package dinara.cards;

public class CreditCard1proc_0_5proc_5cash extends CreditCard{
    // �������� ����� 1% �� �������
    // �������� ����� 5% ��� ������� ����� 5 000 ���.
    private int point = 0;

    // ���������� 0,5% ��� ���������� ����� �� ����������� ��������
    // �� ���������� ���������� ������ ����� �� �����������
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
                System.out.println("������������ �������, ��������� ��: " + numberFormat.format(sum - getCreditLimit()));
                return false;
            }
            setCreditLimit(getCreditLimit() - sum);
            setPoint(getPoint() + calcPoint(sum));
            return true;
        }
        if (getBalance() < sum) {
            int total = sum - getBalance();
            if (getCreditLimit() == 0 || getCreditLimit() < total) {
                System.out.println("������������ �������, ��������� ��: " + numberFormat.format(total - getCreditLimit()));
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
        System.out.println("��������� ��������: " + numberFormat.format(getCreditLimit()));
        System.out.println("����������� ��������: " + numberFormat.format(getBalance()));
        System.out.println("�������� �����: " + numberFormat.format(getPoint()));
        System.out.println("���������� �� ����������: " + numberFormat.format(getSaving()));
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
