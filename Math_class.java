public class Math_class {
    public static void main(String[] args){
        int a = 2;
        int b = -2;
        System.out.println(Math.pow(2,3));
        System.out.println(Math.abs(-2));
        System.out.println(Math.max(a,b));
        System.out.println(Math.min(a,b));
        System.out.println(Math.sqrt(a));
        System.out.println(Math.cbrt(a));
        System.out.println(Math.sin(Math.PI)); // input is angle radian
        System.out.println(Math.cos(Math.PI)); // input is angle radian
        System.out.println(Math.random()); // randomly generate a real number x such that 0<=x<1
        System.out.println(Math.random()*50+50); // randomly generate a real number x such that 50<=x<100
        System.out.println((int)(Math.random()*50+50)); // randomly generate an integer x such that 50<=x<100
        System.out.println(Math.ceil(3.4));
        System.out.println(Math.floor(3.5));
        System.out.println(Math.round(3.5)); //四舍五入
        System.out.println(Math.log(Math.E));
        System.out.println(Math.exp(1));
    }
}
