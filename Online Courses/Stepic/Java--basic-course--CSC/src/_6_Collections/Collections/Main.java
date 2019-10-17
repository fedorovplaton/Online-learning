package _6_Collections.Collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Deque<Integer> deq = new ArrayDeque<>();

        int i = 0;

        while (in.hasNextInt()){

            if(i % 2 != 0){
                deq.addLast(in.nextInt());
            }
            else{
                in.next();
            }
            i++;
        }

        Iterator<Integer> it = deq.descendingIterator();


        StringBuilder ans = new StringBuilder("");

        while (it.hasNext()){
            /*
            Integer elem = new Integer(0);
            elem = it.next();
            System.out.println(elem.toString());*/
            ans.append(it.next().toString());
            ans.append(" ");
        }
        System.out.println(ans.toString());
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        Set <T> s1 = new HashSet<>(set1);
        Set <T> s2 = new HashSet<>(set2);

        s1.removeAll(set2);
        s2.removeAll(set1);

        Set <T> ans = new HashSet<T>();

        ans.addAll(s1);
        ans.addAll(s2);

        return ans;
    }
}
