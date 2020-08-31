package com.example.dataconcat.generator.decimal;

import com.example.dataconcat.config.SimpleJavaRandomGeneratorConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SimpleJavaRandomDecimalGenerator implements DecimalValueGenerator {
    private static final Logger logger = LoggerFactory.getLogger(SimpleJavaRandomDecimalGenerator.class);
    private final SimpleJavaRandomGeneratorConfig simpleJavaRandomGeneratorConfig;

    public SimpleJavaRandomDecimalGenerator(SimpleJavaRandomGeneratorConfig simpleJavaRandomGeneratorConfig) {
        this.simpleJavaRandomGeneratorConfig = simpleJavaRandomGeneratorConfig;
    }

    @Override
    public BigDecimal generate() {
        BigDecimal nextDecimal = new BigDecimal(ThreadLocalRandom.current().nextInt(simpleJavaRandomGeneratorConfig.getMin(), simpleJavaRandomGeneratorConfig.getMax() + 1));
        logger.info("Simple Java Generated value {}", nextDecimal);
        return nextDecimal;
    }
}
