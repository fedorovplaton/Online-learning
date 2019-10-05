package OOP.Integrate;

import java.util.function.DoubleUnaryOperator;

public class Integrate {

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double h  = 0.000001;
        double sum = 0.0;

        double curx = a;

        while(Math.abs(b - curx) >= 0.000001){
            sum += f.applyAsDouble(curx) * h;
            curx += h;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));
    }
}
