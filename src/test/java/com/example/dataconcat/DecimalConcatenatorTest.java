package com.example.dataconcat;

import com.example.dataconcat.factory.DecimalConcatenator;
import com.example.dataconcat.generator.decimal.DecimalValueGenerator;
import com.example.dataconcat.strategy.ConcatOperation;
import com.example.dataconcat.strategy.decimal.DecimalConcatStrategyFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class DecimalConcatenatorTest {
    DecimalConcatStrategyFactory decimalConcatStrategyFactory = new DecimalConcatStrategyFactory();
    DecimalValueGenerator decimalValueGeneratorFirst = Mockito.mock(DecimalValueGenerator.class);
    DecimalValueGenerator decimalValueGeneratorSecond = Mockito.mock(DecimalValueGenerator.class);
    DecimalConcatenator decimalConcatenator = new DecimalConcatenator(Arrays.asList(decimalValueGeneratorFirst, decimalValueGeneratorSecond), decimalConcatStrategyFactory);

    @Test
    @DisplayName("Simple DecimalConcatenator test")
    public void test() {
        //given
        when(decimalValueGeneratorFirst.generate()).thenReturn(new BigDecimal("10"));
        when(decimalValueGeneratorSecond.generate()).thenReturn(new BigDecimal("20"));

        //when
        BigDecimal result = decimalConcatenator.concat(ConcatOperation.ADD);

        //then
        assertThat(result)
                .isEqualTo(new BigDecimal("30"));

    }
}
