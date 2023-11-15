import java.util.*;
public class List_java {
    public static void main(String[] args){
        ArrayList<Integer> ages = new ArrayList<>();
        List<String> lst = new ArrayList<>();
        lst.add("zero");
        lst.add("one");
        lst.set(0, "zed");
        System.out.println(lst.get(0));
        System.out.println(lst.size());
        if (lst.contains("one")) {
            System.out.println("one in lst");
        }
        lst.remove(0);
        for (String elem : lst) {
            System.out.println(elem);
        }
    }
}
