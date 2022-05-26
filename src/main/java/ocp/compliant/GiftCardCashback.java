package ocp.compliant;

import java.math.BigDecimal;

public class GiftCardCashback extends Cashback{
    @Override
    protected BigDecimal percentageCashback() {
        return BigDecimal.valueOf(0.1);
    }
}
