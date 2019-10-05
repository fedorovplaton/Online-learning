package _2_BasicSyntax.isPalindrome;

import java.util.List;

public class isPalindrome {
    public static void main(String[] args) {
        String text = "Madam, I'm Adam!";
        text = text.toLowerCase();
        String regex = "[^a-zA-Z0-9]";
        text = text.replaceAll(regex, "");
        for(int i = 0; i < text.length() / 2; i++){
            if(text.toCharArray()[i] != text.toCharArray()[text.length() - 1 - i])
                System.out.println(false);
        }
        System.out.println(true);
    }
}
