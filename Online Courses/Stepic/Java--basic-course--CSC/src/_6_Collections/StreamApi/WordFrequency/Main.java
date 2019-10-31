package _6_Collections.StreamApi.WordFrequency;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> stream = in.lines();
        stream.forEach(Frec::mapping);

        List list = new ArrayList(Frec.map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                if(b.getValue() - a.getValue() != 0) return b.getValue() - a.getValue();
                else return a.getKey().compareTo(b.getKey());
            }
        });

        for(int i = 0; i < list.size() && i < 10; i++){
            System.out.println(list.get(i).toString().split("=")[0]);
        }





    }

    public static class Frec{
        static Map<String, Integer> map = new HashMap<>();

        public static void mapping(String s) {
            if (!s.isEmpty()) {


                s = s.toLowerCase();

                s = s.replaceAll("[^а-яa-z0-9]", " ");
                s = s.replaceAll(" +", " ");

                if (!s.isEmpty() && s.charAt(s.length() - 1) == ' ') {
                    s = s.substring(0, s.length() - 1);
                }

                if (!s.isEmpty() && s.charAt(0) == ' ') {
                    s = s.substring(1, s.length());
                }

                String[] strArray = s.split(" ");

                for (int i = 0; i < strArray.length; i++) {
                    if (map.containsKey(strArray[i]))
                        map.put(strArray[i], map.get(strArray[i]) + 1);
                    else
                        map.put(strArray[i], 1);
                }
            }
        }
        }
}
