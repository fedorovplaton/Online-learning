package _5_InputOutput._2_EndOfStringWinToUnix;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;


        int prev1 = inputStream.read();
        int next2;

        while(prev1 != -1){
            next2 = inputStream.read();
            if (!(next2 == 10 && prev1 == 13)){
                outputStream.write(prev1);
            }
            prev1 = next2;
        }
        outputStream.flush();
    }
}
