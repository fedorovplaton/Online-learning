import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class main {
    public static void main(String[] args) {

        Map<String, List<String>> map = new HashMap<>();
        String a = "a";
        List <String> list = new LinkedList<>();
        list.add("b");
        list.add("c");

        map.put(a, list);

        List b = map.get("a");

        System.out.println(b.size());
        b.add("c");

        List ans = map.get("a");

        System.out.println(ans.size());



    }

}


