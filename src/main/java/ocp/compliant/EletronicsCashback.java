package ocp.compliant;

import java.math.BigDecimal;

public class EletronicsCashback extends Cashback{

    @Override
    protected BigDecimal percentageCashback() {
        return BigDecimal.valueOf(0.01);
    }

}
