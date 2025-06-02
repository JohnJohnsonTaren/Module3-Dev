public class SumCalculator {
    public int sumCalculate(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Значення 'n' повинно бути позитивним числом.");
        }
        return n * (n + 1) / 2;
    }
}