package com.example.dataconcat.factory;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * simple factory, for concat mode extending purposes
 */
@Component
public class ConcatenatorFactory {

    private final Map<ConcatMode, DataConcatenator<?>> concatModeToDataConcatenators;

    public ConcatenatorFactory(List<DataConcatenator<?>> dataConcatenators) {
        concatModeToDataConcatenators = constructConcatModeTodDataConcatenators(dataConcatenators);
    }

    private Map<ConcatMode, DataConcatenator<?>> constructConcatModeTodDataConcatenators(List<DataConcatenator<?>> dataConcatenators) {
        return dataConcatenators.stream()
                .collect(Collectors.toMap(DataConcatenator::getConcatMode, dataConcatenator -> dataConcatenator));
    }

    public DataConcatenator<?> getDataConcatenator(ConcatMode concatMode) {
        return concatModeToDataConcatenators.get(concatMode);
    }


}
