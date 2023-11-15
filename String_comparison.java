public class String_comparison {
    public static void main(String[] args)
    {
        String s1 = "HELLO"; //When we create a string like this, a reference is returned from the Java String Pool
        String s2 = "HELLO"; //Since the content in s2 is the same as the content in s1, the same reference from the Java String Pool will be returned
        String s3 =  new String("HELLO"); // When we create a string like this, a reference not from Java String Pool will be returned

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // true
    }
}
/* Remember that strings in Java is actually a special array, which is an object(a pointer).
 We can use == operators for reference comparison (address comparison) and .equals() method for content comparison.
In simple words, == checks if both objects point to the same memory location whereas
.equals() evaluates to the comparison of values in the objects.
 */

/*
Java String Pool: Java String pool refers to collection of Strings which are stored in heap memory.
In this, whenever a new object is created, String pool first checks whether the object is already present
in the pool or not. If it is present, then same reference is returned to the variable else new object
will be created in the String pool and the respective reference will be returned.
 */