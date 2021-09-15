package com;

import java.math.BigInteger;

public class LongNumbersCalculator
{
    private final int N;
    private BigInteger _nominator = BigInteger.ZERO;
    private BigInteger _denominator = BigInteger.ZERO;

    public LongNumbersCalculator(int n)
    {
        N = n;
    }

    private void reduceFraction()
    {
        var divider = _nominator.gcd(_denominator);
        if (!divider.equals(BigInteger.ZERO))
        {
            _nominator = _nominator.divide(divider);
            _denominator = _denominator.divide(divider);
        }
    }

    private BigInteger findLowestCommonMultiplier(BigInteger firstDenominator, BigInteger secondDenominator)
    {
        return firstDenominator.multiply(secondDenominator).divide(firstDenominator.gcd(secondDenominator));
    }

    private BigInteger getNominatorIteration(int i)
    {
        return BigInteger.ONE;
    }

    private BigInteger getDenominatorIteration(int i)
    {
        return BigInteger.valueOf(i).pow(2).multiply(BigInteger.valueOf(9L)).add(BigInteger.valueOf(i)
                .multiply(BigInteger.valueOf(3L))).subtract(BigInteger.valueOf(4L));
    }

    public BigInteger[] getSum()
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
                var divider= lcm.divide(_denominator);
                _nominator = _nominator.multiply(divider);
                _denominator = _denominator.multiply(divider);

                divider = lcm.divide(currentDenominator);
                currentNominator = currentNominator.multiply(divider);

                _nominator = _nominator.add(currentNominator);
            }

            reduceFraction();
        }

        return new BigInteger[] { _nominator, _denominator };
    }
}
