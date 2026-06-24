package FinancialForecasting;

public class FinancialForecast
{
    public static double predictFutureValue(double currentValue, double growthRate, int years) {

        // Base condition
        if (years == 0) {
            return currentValue;
        }

        // Recursive step
        return predictFutureValue(currentValue, growthRate, years - 1)
                * (1 + growthRate);
    }

    public static void main(String[] args) {

        double currentValue = 1000.0;
        double growthRate = 0.10; // 10%
        int years = 5;

        double result = predictFutureValue(currentValue, growthRate, years);

        System.out.println("Future Value after " + years + " years: " + result);
    }
}
