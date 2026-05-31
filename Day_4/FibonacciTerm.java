import java.util.Scanner;

public class FibonacciTerm {
    public static void main(String[] args) {
        int num;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of nth term: ");
        num = input.nextInt();

        long n1 = 0;
        long n2 = 1;
        long fib = 0;
        
            if(num == 1){
                fib = n1;
            }else if(num == 2){
                fib = n2;
            }else{
                for(int i = 3;i <= num;i++){
                fib = n1+n2;
                n1 = n2;
                n2 = fib;
                }
            }
        System.out.println("The "+num+"th term of fibonacci series is "+fib);
    }
}
