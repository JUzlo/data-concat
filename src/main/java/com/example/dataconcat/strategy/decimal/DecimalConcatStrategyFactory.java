package com.example.dataconcat.strategy.decimal;

import com.example.dataconcat.strategy.ConcatOperation;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DecimalConcatStrategyFactory {
    private final Map<ConcatOperation, DecimalConcatStrategy> concatStrategyToDecimalStrategy = Map.of(ConcatOperation.ADD, DecimalConcatStrategy.add());

    public DecimalConcatStrategy getDecimalStrategy(ConcatOperation concatOperation) {
        return concatStrategyToDecimalStrategy.get(concatOperation);
    }
}
