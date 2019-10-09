package _5_InputOutput._3_InputToCharset;

import java.nio.charset.Charset;

import java.io.IOException;
import java.io.*;

public class Main {
    public static void main(String[] args) {

    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        StringBuilder string = new StringBuilder();
        Reader reader = new InputStreamReader(inputStream, charset);

        int b = 0;
        while((b = reader.read()) != -1){
            string.append(Character.toChars(b));
        }
        return string.toString();
    }
}
