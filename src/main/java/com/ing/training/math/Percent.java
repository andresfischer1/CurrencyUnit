package com.ing.training.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Objects;

public class Percent {

    private static final String WRITE_PATTERN = "#.00%";

    private BigDecimal percentAsBigDecimal;

    public Percent(String percentAsText) throws ParseException {
        this.percentAsBigDecimal = parsePercent(percentAsText);
    }

    public Percent(BigDecimal percentAsBigDecimal) {
        this.percentAsBigDecimal = percentAsBigDecimal.
                setScale(5, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal parsePercent(String percentAsText) throws ParseException {
        DecimalFormat df = new DecimalFormat("#.##%");
        df.setParseBigDecimal(true);
        return (BigDecimal) df.parse(percentAsText);
    }

    public BigDecimal getAsBigDecimal() {
        percentAsBigDecimal = percentAsBigDecimal.setScale(5, RoundingMode.HALF_UP);
        return percentAsBigDecimal;
    }

    @Override
    public String toString() {
        return new DecimalFormat(WRITE_PATTERN).format(percentAsBigDecimal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Percent that = (Percent) o;
        return Objects.equals(percentAsBigDecimal, that.percentAsBigDecimal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(percentAsBigDecimal);
    }
    
}
