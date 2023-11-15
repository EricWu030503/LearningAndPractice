import java.util.Scanner;

public class User_input {
    public static void main(String[] args){
        Scanner scanner =  new Scanner(System.in);
        System.out.println("What's your name: ");
        String name = scanner.nextLine();
        System.out.println("How old are you: ");
        int age = Integer.parseInt(scanner.nextLine());
    }
}
