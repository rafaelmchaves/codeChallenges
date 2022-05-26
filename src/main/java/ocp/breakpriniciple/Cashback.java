package ocp.breakpriniciple;

import java.math.BigDecimal;

public class Cashback {

    public BigDecimal calculate(BigDecimal value, ProductType productType) {

        if(productType.equals(ProductType.ELETRONICS)) {
            return value.multiply(BigDecimal.valueOf(0.01));
        }
        if(productType.equals(ProductType.GIFT_CARD)) {
            return value.multiply(BigDecimal.valueOf(0.1));
        }
        if(productType.equals(ProductType.CLOTHES)) {
            return value.multiply(BigDecimal.valueOf(0.05));
        }
        else {
            return BigDecimal.ZERO;
        }
    }
}
