import java.util.*;
public class Map_java {
    public static void main(String[] args){
        Map<String, String> map = new HashMap<>(); //key type and then value type
        map.put("hello", "hi"); // key,value
        map.put("hello", "goodbye"); //覆盖
        System.out.println(map.get("hello"));
        System.out.println(map.size());
        if (map.containsKey("hello")) {
            System.out.println("\"hello\" in map");
        }
        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }
}

//