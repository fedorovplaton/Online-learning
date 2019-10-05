package _2_BasicSyntax.is2Degree;

import static java.lang.Math.*;

public class is2Degree {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(0));
    }
    public static boolean isPowerOfTwo(int value) {
        int valueAbs = Math.abs(value);
        int ans = valueAbs&(valueAbs - 1);
        if(ans == 0) return true;
        else return false;
    }
}
