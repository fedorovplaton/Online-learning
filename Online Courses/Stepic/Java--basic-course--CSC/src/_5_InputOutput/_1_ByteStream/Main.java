package _5_InputOutput._1_ByteStream;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {
        //Another task
        Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII);
        writer.write(300);
        writer.close();

        /*
        InputStream stream;
        int result;
        stream = getStream( new byte[] { 0x33, 0x45, 0x01});

        result = checkSumOfStream(stream);
        System.out.print(result);*/
    }

    public static InputStream getStream(byte [] data)  {
        return new ByteArrayInputStream(data);
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int sum = 0;
        int currentByte;
        while((currentByte = inputStream.read()) > 0){
            sum = Integer.rotateLeft(sum, 1) ^ currentByte;
        }
        return sum;
    }


}