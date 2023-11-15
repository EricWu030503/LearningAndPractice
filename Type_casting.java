public class Type_casting {
    public static void main(String args[]) {
        int a =Integer.parseInt("9");
        int b = Integer.parseInt("444",16);
        double c = Double.parseDouble("5");
        // Integer.parseInt and Double.parseDouble can only take strings as input
        int d = (int) c;
        double e = a;
        int f = 'a';


        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
    }
}
