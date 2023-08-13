package dinara;

import dinara.cards.*;

public class Main {
    public static void main(String[] args) {

        // ��������� ����� � 1
        DebitCard debitCard = new DebitCard();
        debitCard.setBalance(1000);
        debitCard.replenish(200);
        debitCard.balanceInformation();
        debitCard.pay(2000);
        debitCard.pay(100);
        debitCard.balanceInformation();

        // ��������� ����� � 2
        DebitCard1proc debitCard1proc = new DebitCard1proc();
        debitCard1proc.setBalance(500);
        debitCard1proc.replenish(300);
        debitCard1proc.pay(800);
        debitCard1proc.replenish(20000);
        debitCard1proc.pay(15000);
        debitCard1proc.informationAboutAvailableFunds();

        // ��������� ����� � 3
        DebitCard1proc_0_5proc debitCard1proc_0_5proc = new DebitCard1proc_0_5proc();
        debitCard1proc_0_5proc.setBalance(0);
        debitCard1proc_0_5proc.replenish(8000);
        debitCard1proc_0_5proc.replenish(15000);
        debitCard1proc_0_5proc.pay(12000);
        debitCard1proc_0_5proc.replenish(200);
        debitCard1proc_0_5proc.pay(820);
        debitCard1proc_0_5proc.informationAboutAvailableFunds();

        // ��������� ����� � 1
        CreditCard creditCard = new CreditCard();
        creditCard.setCreditLimit(10000);
        creditCard.setBalance(0);

        System.out.println();
        System.out.println("1. �������� �� 5 000 ���.");
        creditCard.pay(5000);
        creditCard.balanceInformation();

        System.out.println();
        System.out.println("2. �������� �� 2 000 ���.");
        creditCard.pay(2000);
        creditCard.balanceInformation();

        System.out.println();
        System.out.println("3. �������� �� 5 000 ���.");
        creditCard.pay(5000);
        creditCard.balanceInformation();

        System.out.println();
        System.out.println("4. �������� �� 5 000 ���.");
        creditCard.pay(5000);
        creditCard.balanceInformation();

        System.out.println();
        System.out.println("5. ��������� �� 5 000 ���.");
        creditCard.replenish(5000);
        creditCard.balanceInformation();

        System.out.println();
        System.out.println("6. ��������� �� 12 000 ���.");
        creditCard.replenish(12000);
        creditCard.balanceInformation();

        System.out.println();
        System.out.println("7. ��������� �� 15 000 ���.");
        creditCard.replenish(15000);
        creditCard.balanceInformation();

        System.out.println();
        System.out.println("8. �������� �� 28 000 ���.");
        creditCard.pay(28000);
        creditCard.balanceInformation();

        System.out.println();
        System.out.println("9. ��������� �� 1 000 ���.");
        creditCard.replenish(1000);
        creditCard.balanceInformation();

        // ��������� ����� � 2
        CreditCard1proc_0_5proc_5cash creditCard2 = new CreditCard1proc_0_5proc_5cash();
        creditCard2.setCreditLimit(10000);
        creditCard2.setBalance(5000);
        creditCard2.informationAboutAvailableFunds();

        System.out.println();
        System.out.println("1. �������� �� 15 000 ���.");
        creditCard2.pay(15000);
        creditCard2.informationAboutAvailableFunds();

        System.out.println();
        System.out.println("2. �������� �� 5 000 ���.");
        creditCard2.pay(5000);
        creditCard2.informationAboutAvailableFunds();

        System.out.println();
        System.out.println("3. ��������� �� 12 000 ���.");
        creditCard2.replenish(12000);
        creditCard2.informationAboutAvailableFunds();

        System.out.println();
        System.out.println("4. �������� �� 4 000 ���.");
        creditCard2.pay(4000);
        creditCard2.informationAboutAvailableFunds();

        // ��������� ����� � 3
        CreditCard1proc_0_5proc_5cashlimit creditCard3 = new CreditCard1proc_0_5proc_5cashlimit();
        creditCard3.setCreditLimit(10000);
        creditCard3.setBalance(25000);
        creditCard3.informationAboutAvailableFunds();

        System.out.println();
        System.out.println("1. �������� �� 30 000 ���.");
        creditCard3.pay(30000);
        creditCard3.informationAboutAvailableFunds();

        System.out.println();
        System.out.println("2. �������� �� 5 000 ���.");
        creditCard3.pay(5000);
        creditCard3.informationAboutAvailableFunds();

        System.out.println();
        System.out.println("3. ��������� �� 12 000 ���.");
        creditCard3.replenish(12000);
        creditCard3.informationAboutAvailableFunds();

        System.out.println();
        System.out.println("4. �������� �� 4 000 ���.");
        creditCard3.pay(4000);
        creditCard3.informationAboutAvailableFunds();
    }
}
