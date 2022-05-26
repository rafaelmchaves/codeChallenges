package ocp.compliant;

import java.math.BigDecimal;

public class ClothesCashback extends Cashback{

    @Override
    protected BigDecimal percentageCashback() {
        return BigDecimal.valueOf(0.05);
    }
}
