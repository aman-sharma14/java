import java.util.Scanner;

class first{

    public static int factorial (int n){
        if (n <= 1){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number: ");
        int a = scanner.nextInt();

        System.out.println(factorial(a));

        System.out.println("Enter number: ");
        a = scanner.nextInt();

        System.out.println(factorial(a));


        scanner.close();

    }
}