import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumCalculatorTest {
    private SumCalculator sumCalculator;

    @BeforeEach
    void beforeEach() {
        sumCalculator = new SumCalculator();
    }

    @Test // вызов sum(1) возвращает 1
    public void testSumOne() {
        Expression expression = new Expression(Expression.Operator.plus, 1);
        assertEquals(1, sumCalculator.sumCalculate(expression.getSum()));
    }

    @Test // вызов sum(3) возвращает 6
    public void testSumThree() {
        Expression expression = new Expression(Expression.Operator.plus, 3);
        assertEquals(6, sumCalculator.sumCalculate(expression.getSum()));
    }


    @Test // вызов sum(0) возвращает 0
    public void testSumZero() {
        Expression[] invalidInputs = {
                new Expression(Expression.Operator.plus, 0)
        };
        for (Expression invalidInput: invalidInputs) {
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> sumCalculator.sumCalculate(invalidInput.getSum()),
                    invalidInput + ""
            );
        }
    }

    @Test // вызов sum(-1) выбрасывает исключение IllegalArgumentException
    public void testSumNegativeThrowsException() {
        Expression[] invalidInputs = {new Expression(Expression.Operator.plus, -1)
        };
        for (Expression invalidInput: invalidInputs) {
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> sumCalculator.sumCalculate(invalidInput.getSum()),
                    invalidInput + ""
            );
        }
    }
}