package _5_InputOutput._4_GetSumOfDouubles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println(Double.parseDouble("df"));
        }
        catch (NumberFormatException e){

        }
        double sum = 0;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            String[] elements = s.split(" ");
            for(int i = 0; i < elements.length; i++){

                try{
                    double d = Double.parseDouble(elements[i]);
                    sum += d;
                }
                catch (NumberFormatException e){

                }
            }
        }
        System.out.printf("%.6f", sum);
    }
}
