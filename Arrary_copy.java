public class Arrary_copy {
    public static void main(String[] args){
        int[] a = {1,2,3};
        int[] b = a;
        int[] c = a.clone();
        a[0] = 0;
        System.out.println(b[0]);
        System.out.println(c[0]);

        char[] original = {'a', 'b', 'c', 'd', 'e'};
        char[] destination = new char[10]; // A longer array with space for 10 characters

        // Copy contents of original into destination
        System.arraycopy(original, 0, destination, 0, original.length);
    }
}
