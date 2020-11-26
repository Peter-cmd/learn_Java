package calculator;

public class Calculator {

    private static Integer result = 0;

    public void add(Integer n) {
        result += n;
    }

    public void substract(Integer n) {
        result -= 1;  // BUG
    }

    public void multiply(Integer n) {
        result *= n;
    }

    public void divide(Integer n) {
        result /= n;
    }

    public void square(Integer n) {
        result = n * n;
    }

    public void squareRoot(Integer n) {
        for (; ;);  //BUG
    }

    public Integer getResult() {
        return result;
    }

    public void clear() {
        result = 0;
    }
}
