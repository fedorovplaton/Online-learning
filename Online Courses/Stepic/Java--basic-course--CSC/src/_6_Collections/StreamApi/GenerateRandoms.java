package _6_Collections.StreamApi;

import java.util.stream.IntStream;

public class GenerateRandoms {
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> R(n * n));
    }

    public static int R(int n){
        n = n / 10;
        int m = 0;
        int i = 1;
        while (n != 0 && i < 1000){
            m += (n - (n / 10) * 10) * i;
            n /= 10;
            i *= 10;
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(R(200));
    }
}
