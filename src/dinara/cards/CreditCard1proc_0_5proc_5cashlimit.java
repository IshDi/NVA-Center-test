package dinara.cards;

public class CreditCard1proc_0_5proc_5cashlimit extends CreditCard1proc_0_5proc_5cash{
    // �������� ����� 5% ��� ������� ����� 5 000 ���., �� �������� ����� �� ����� 1000 ���.
    @Override
    public int calcPoint(int sum) {
        int total = 0;
        if (sum >= 5000) {
            total = (int)(sum * 0.05);
            if (total > 1000) {
                total = 1000;
            }
            return total;
        }
        total = (int)(sum * 0.01);
        if (total > 1000) {
            total = 1000;
        }
        return total;
    }
}
