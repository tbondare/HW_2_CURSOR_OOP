import java.math.BigDecimal;

public class Fractions {
    private long longInt;
    private short shortInt;

    public Fractions(long longInt, short shortInt) {
        this.longInt = longInt;
        this.shortInt = shortInt;
    }

    public void Sum(Fractions otherNumber) {
        checkSignedShort();
        otherNumber.checkSignedShort();
        BigDecimal result = doTwoNumbersToOneNumber().add(otherNumber.doTwoNumbersToOneNumber());
        doFractionFromBigDecimal(result);
    }

    public void Sub(Fractions otherNumber) {
        checkSignedShort();
        otherNumber.checkSignedShort();
        BigDecimal result = doTwoNumbersToOneNumber().subtract(otherNumber.doTwoNumbersToOneNumber());
        doFractionFromBigDecimal(result);
    }

    public void Mul(Fractions otherNumber) {
        checkSignedShort();
        otherNumber.checkSignedShort();
        BigDecimal result = doTwoNumbersToOneNumber().multiply(otherNumber.doTwoNumbersToOneNumber());
        doFractionFromBigDecimal(result);
    }

    public boolean Equal(Fractions otherNumber) {
        checkSignedShort();
        otherNumber.checkSignedShort();
        return longInt == otherNumber.longInt && shortInt == otherNumber.shortInt;
    }

    public void print() {
        System.out.println(doTwoNumbersToOneNumber().toString());
    }

    private BigDecimal doTwoNumbersToOneNumber() {
        BigDecimal decimalPart = new BigDecimal(shortInt).divide(new BigDecimal(10000));
        return decimalPart.add(new BigDecimal(longInt));
    }

    private void doFractionFromBigDecimal(BigDecimal result) {
        longInt = result.longValue();
        BigDecimal decimalPart = result.subtract(new BigDecimal(longInt));
        shortInt = decimalPart.multiply(new BigDecimal(10000)).shortValue();
    }

    private void checkSignedShort() {
        if (shortInt < 0) {
            System.out.println("Not correct number after point. It can't be signed");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        Fractions fractionFirst = new Fractions(1L, (short)2345);
        Fractions fractionSec = new Fractions(0L, (short)7689);
        fractionFirst.Sum(fractionSec);
        fractionFirst.print();

        System.out.println(fractionFirst.Equal(new Fractions(1L, (short)2345)));

        fractionFirst.Sub(fractionSec);
        fractionFirst.print();

        System.out.println(fractionFirst.Equal(new Fractions(1L, (short)2345)));

        fractionFirst.Mul(fractionSec);
        fractionFirst.print();
    }
}
