package _2_BasicSyntax.factorial;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(30));
    }
    public static BigInteger factorial(int value) {
        BigInteger a = BigInteger.valueOf(1);
        for(int i = 2; i <= value; i++){
            BigInteger b = BigInteger.valueOf(i);
            a = a.multiply(b);
        }
        return a;
    }
}
