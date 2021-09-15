package com;

public class ShortNumbersCalculator
{
    private final int N;
    private long _nominator;
    private long _denominator;

    public ShortNumbersCalculator(int n)
    {
        N = n;
    }

    private long getNominatorIteration(int i)
    {
        return 1;
    }

    private long getDenominatorIteration(int i)
    {
        return 9L*i*i + 3L*i - 4;
    }

    private long findGreatestCommonDivider(long nominator, long denominator)
    {
        return denominator == 0 ? nominator : findGreatestCommonDivider(denominator, nominator % denominator);
    }

    private long findLowestCommonMultiplier(long firstDenominator, long secondDenominator)
    {
        return (firstDenominator * secondDenominator) / findGreatestCommonDivider(firstDenominator, secondDenominator);
    }

    public long[] getSum()
    {
        for (int i = 1; i <= N; ++i)
        {
            var currentNominator = getNominatorIteration(i);
            var currentDenominator = getDenominatorIteration(i);

            if (i == 1)
            {
                _nominator = currentNominator;
                _denominator = currentDenominator;
            }
            else
            {
                var lcm = findLowestCommonMultiplier(_denominator, currentDenominator);
                var divider= lcm / _denominator;
                _nominator *= divider;
                _denominator *= divider;

                divider = lcm / currentDenominator;
                currentNominator *= divider;

                _nominator += currentNominator;
            }

            reduceFraction();
        }

        return new long[] { _nominator, _denominator };
    }

    private void reduceFraction()
    {
        var divider = findGreatestCommonDivider(_nominator, _denominator);
        if (divider != 0)
        {
            _nominator /= divider;
            _denominator /= divider;
        }
    }
}
