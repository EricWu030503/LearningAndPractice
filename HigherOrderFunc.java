interface IntUnaryFunction {
    int apply(int x);
}

class TenX implements IntUnaryFunction {
    /** Returns ten times the argument. */
    public int apply(int x) {
        return 10 * x;
    }
}

public class HigherOrderFunc {
    public static int doTwice(IntUnaryFunction f, int x) {
        return f.apply(f.apply(x));
    }

    public static void main(String[] args) {
        IntUnaryFunction tenX = new TenX();
        System.out.println(doTwice(tenX, 2));
    }

}
