import java.util.Arrays;

public class Arrays_java {
    public static void main(String[] args){
        int[] x = {0,1,2,3};
        int[] y = new int[5];// int[] y tells the computer the existence of an integer array called y; new int[5] returns a memory address with 5 memory cells reserved for y
        int[] z;
        z = new int[]{1,2,3}; // z = {1,2,3} will cause errors
        x[0] = 1;

        for (int i: x){
            System.out.println(i);
        }
        System.out.println(" ");

        for (int i: y){
            System.out.println(i);
        }
        System.out.println(" ");

        System.out.println(x.length);
        System.out.println(Arrays.toString(x));

    }
}

// array is a pointer
// we can also create an array of objects
// we cannot change the length of an array
// arrays don't have methods