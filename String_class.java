public class String_class {
    public static void main(String[] args){
        String s = "abcdEab";
        System.out.println(s+"f");
        System.out.println(s+1);
        System.out.println(s.length());
        System.out.println(s.substring(1));
        System.out.println(s.substring(1,4));
        System.out.println(s.indexOf("bc"));
        System.out.println(s.lastIndexOf("a"));
        System.out.println(s.charAt(3));
        System.out.println("\"hello\"");
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
        System.out.println(s.contains("g"));
        System.out.println(s.repeat(3));
        System.out.println(s.replace("ab","AB")); //replace all; it will not change the original string
        System.out.println(s.replaceFirst("ab","AB"));
        System.out.println(s.trim()); //remove the blank at the end of the string if any
        System.out.println(s.isBlank()); // return true if the string is null, "", or " "
        System.out.println(s.isEmpty()); // return true if the string is null or ""

        String a = "hello";
        String b = a;
        a = "hi";
        System.out.println(a); // print out hi
        System.out.println(b); // print out hello
    }
}

