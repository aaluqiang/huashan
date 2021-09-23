import java.math.BigDecimal;

public class testBigDecimal {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal(0);
        BigDecimal a = b.add(new BigDecimal(1));
        System.out.println(a);
    }
}

