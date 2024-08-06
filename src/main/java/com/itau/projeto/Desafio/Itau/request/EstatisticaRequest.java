package com.itau.projeto.Desafio.Itau.request;

import lombok.Data;

import java.util.DoubleSummaryStatistics;

@Data
public class EstatisticaRequest {

    private final long count;
    private final Double sum;
    private final Double avg;
    private final Double min;
    private final Double max;

    public EstatisticaRequest() {
        this(new DoubleSummaryStatistics());
    }

    public EstatisticaRequest(final DoubleSummaryStatistics doubleSummaryStatistics) {
        this.count = doubleSummaryStatistics.getCount();
        this.sum = doubleSummaryStatistics.getSum();
        this.avg = doubleSummaryStatistics.getAverage();
        this.min = doubleSummaryStatistics.getMin() == Double.POSITIVE_INFINITY ? 0 : doubleSummaryStatistics.getMin();
        this.max = doubleSummaryStatistics.getMax() == Double.NEGATIVE_INFINITY ? 0 : doubleSummaryStatistics.getMax();

    }
}
