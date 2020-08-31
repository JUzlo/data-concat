package com.example.dataconcat.strategy.decimal;

import java.math.BigDecimal;

public interface DecimalConcatStrategy {
    BigDecimal concat(BigDecimal first, BigDecimal second);

    static DecimalConcatStrategy add() {
        return BigDecimal::add;
    }
}

