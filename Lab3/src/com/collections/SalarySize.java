package com.collections;

public enum SalarySize {
    Low(0, 300),
    Medium(301, 700),
    High(701, Integer.MAX_VALUE);

    private final int min;
    private final int max;

    SalarySize(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}