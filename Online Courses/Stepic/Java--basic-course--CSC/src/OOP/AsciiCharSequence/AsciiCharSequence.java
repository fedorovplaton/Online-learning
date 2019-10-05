package OOP.AsciiCharSequence;

public class AsciiCharSequence implements java.lang.CharSequence{
    byte[] array;

    public AsciiCharSequence (byte[] chars){
        this.array = chars;
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public char charAt(int index) {
        return (char) array[index];
    }

    @Override
    public AsciiCharSequence subSequence(int start, int end) {
        byte [] asciiCharSequence = new byte[end - start];
        for(int i = start; i < end; i++){
            asciiCharSequence[i - start] = this.array[i];
        }
        return new AsciiCharSequence(asciiCharSequence);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        for(int i = 0; i < array.length; i++){
            str.append((char) array[i]);
        }
        return str.toString();
    }
}
