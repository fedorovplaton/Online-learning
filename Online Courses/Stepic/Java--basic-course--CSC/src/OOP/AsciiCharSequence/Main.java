package OOP.AsciiCharSequence;

public class Main {
    public static void main(String[] args) {
        byte[] arrString = new byte[] {'a', 'b', 'c', 'd','e','f','g','h'};
        AsciiCharSequence ascString = new AsciiCharSequence(arrString);
        System.out.println(ascString);
        System.out.println(ascString.subSequence(1, 3));
    }
}
