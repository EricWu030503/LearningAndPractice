public class Loops {
    public static void main(String[] args){
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        } // while loop
        System.out.println("");

        do{
            System.out.println(i);
            i++;
        }while(i<11); // do while loop
        System.out.println("");

        for (int j = 0; j < 10; j ++) {
            System.out.println(j);
        } // for loop
        System.out.println("");

        for (int j = 9; j >= 0; j --) {
            System.out.println(j);
        } // reverse for loop
        System.out.println("");

        int arr[] = {5,6,7};
        for (int j : arr){
            System.out.println(j);
        } // for loop in an array
    }
}
