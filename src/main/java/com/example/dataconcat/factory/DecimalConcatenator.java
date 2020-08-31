package com.example.dataconcat.factory;

import com.example.dataconcat.factory.exception.ConcatenatorException;
import com.example.dataconcat.generator.decimal.DecimalValueGenerator;
import com.example.dataconcat.generator.decimal.SimpleJavaRandomDecimalGenerator;
import com.example.dataconcat.strategy.ConcatOperation;
import com.example.dataconcat.strategy.decimal.DecimalConcatStrategy;
import com.example.dataconcat.strategy.decimal.DecimalConcatStrategyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DecimalConcatenator extends DataConcatenator<BigDecimal> {
    private static final Logger logger = LoggerFactory.getLogger(SimpleJavaRandomDecimalGenerator.class);
    private final ConcatMode concatMode = ConcatMode.DECIMAL;
    private final List<DecimalValueGenerator> decimalValueGenerators;
    private final DecimalConcatStrategyFactory decimalConcatStrategyFactory;

    public DecimalConcatenator(List<DecimalValueGenerator> decimalValueGenerators, DecimalConcatStrategyFactory decimalConcatStrategyFactory) {
        this.decimalValueGenerators = decimalValueGenerators;
        this.decimalConcatStrategyFactory = decimalConcatStrategyFactory;
    }

    @Override
    public BigDecimal concat(ConcatOperation concatOperation) {
        DecimalConcatStrategy decimalStrategy = decimalConcatStrategyFactory.getDecimalStrategy(concatOperation);
        BigDecimal result = decimalValueGenerators.stream()
                .map(DecimalValueGenerator::generate)
                .reduce(decimalStrategy::concat)
                .orElseThrow(() -> new ConcatenatorException("Unexpected Exception"));

        logger.info("Concat result: {} \n", result);
        return result;
    }

    @Override
    public ConcatMode getConcatMode() {
        return concatMode;
    }
}
