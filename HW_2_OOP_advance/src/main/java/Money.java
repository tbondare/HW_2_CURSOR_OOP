import java.math.BigDecimal;

public class Money {
    long hryvnia;
    byte penny;

    public Money(long hryvnia, byte penny) {
        this.hryvnia = hryvnia;
        this.penny = penny;
    }

    public void Sum(Money anotherMoney) {
        BigDecimal result = doOneMoneyFromTwo().add(anotherMoney.doOneMoneyFromTwo());
        doHryvnaAndPenny(result);
    }

    public void Sub(Money anotherMoney) {
        BigDecimal result = doOneMoneyFromTwo().subtract(anotherMoney.doOneMoneyFromTwo());
        doHryvnaAndPenny(result);
    }

    public void Mul(Money anotherMoney) {
        BigDecimal result = doOneMoneyFromTwo().multiply(anotherMoney.doOneMoneyFromTwo());
        doHryvnaAndPenny(result);
    }

    public void Div(Money anotherMoney) {
        BigDecimal result = doOneMoneyFromTwo().divide(anotherMoney.doOneMoneyFromTwo(), 3);
        doHryvnaAndPenny(result);
    }

    public boolean Equal(Money anotherMoney) {
        return hryvnia == anotherMoney.hryvnia && penny == anotherMoney.penny;
    }

    public void print() {
        System.out.println(hryvnia + "," + penny);
    }

    private BigDecimal doOneMoneyFromTwo() {
        if (penny > 99) {
            penny -= 99;
            hryvnia += 1;
        }
        BigDecimal pennyPart = new BigDecimal(penny).divide(new BigDecimal(100));
        BigDecimal result = new BigDecimal(String.valueOf(new BigDecimal(hryvnia).add(pennyPart)));
        return result;
    }

    private void doHryvnaAndPenny(BigDecimal result) {
        hryvnia = result.longValue();
        penny = result.subtract(new BigDecimal(hryvnia)).multiply(new BigDecimal(100)).byteValue();
    }

    public static void main(String[] args) {
        Money moneyOne = new Money(123L, (byte) 123);
        Money moneyTwo = new Money(456L, (byte) 123);
        moneyOne.Sum(moneyTwo);
        moneyOne.print();
        moneyOne.Sub(moneyTwo);
        moneyOne.print();
        moneyOne.Mul(moneyTwo);
        moneyOne.print();
        moneyOne.Div(moneyTwo);
        moneyOne.print();
        System.out.println(moneyOne.Equal(moneyTwo));
    }
}
