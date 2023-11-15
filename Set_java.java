import java.util.*;
public class Set_java {
    public static void main(String[] args){
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        set.remove(2);
        System.out.println(set.size());
        if (set.contains(1)) {
            System.out.println("1 in set");
        }
        for (int elem : set) {
            System.out.println(elem);
        }
    }
}