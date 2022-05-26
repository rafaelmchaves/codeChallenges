package ocp.compliant;

import java.math.BigDecimal;

public abstract class Cashback {

    public BigDecimal calculate(BigDecimal value) {
        return value.multiply(percentageCashback());
    }

    protected abstract BigDecimal percentageCashback();
}
