package com.example.dataconcat.task;

import com.example.dataconcat.factory.ConcatMode;
import com.example.dataconcat.factory.ConcatenatorFactory;
import com.example.dataconcat.strategy.ConcatOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class ConcatExecutor {
    @Value("${config.executor.rounds}")
    private int rounds;

    private final ConcatenatorFactory concatenatorFactory;

    public ConcatExecutor(ConcatenatorFactory concatenatorFactory) {
        this.concatenatorFactory = concatenatorFactory;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void execute() {
        IntStream.range(0, rounds).forEach((i) -> concatenatorFactory
                .getDataConcatenator(ConcatMode.DECIMAL)
                .concat(ConcatOperation.ADD));
    }


}
