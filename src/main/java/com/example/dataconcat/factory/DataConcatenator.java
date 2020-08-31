package com.example.dataconcat.factory;

import com.example.dataconcat.strategy.ConcatOperation;

public abstract class DataConcatenator<T> {
    public abstract T concat(ConcatOperation operation);

    public abstract ConcatMode getConcatMode();

}
