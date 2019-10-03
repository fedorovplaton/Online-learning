package _2_BasicSyntax.FlipBit;

public class FlipBit {
    public static void main(String[] args) {
        System.out.println(flipBit(0, 1));
    }
    public static int flipBit(int value, int bitIndex) {
        return value ^ (1 << (bitIndex - 1));
    }
}
