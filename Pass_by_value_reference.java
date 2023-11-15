public class Pass_by_value_reference {
    public static void main(String[] args) {
        int[] arr = {5};

        modify(arr);

        System.out.println(arr[0]);   // Outputs: 10
    }

    public static void modify(int[] a) {
        a[0] = a[0] * 2;              // This modifies the array's content.
        a = new int[]{15};            // This re-assigns the local reference but doesn't affect the original 'arr'.
    }

}
