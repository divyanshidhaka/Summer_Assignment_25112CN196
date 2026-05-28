import java.util.Scanner;
public FactorialOfANumber{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        long factorial = 1;
        for(int i = 1; i<=num ; i++){
            factorial = factorial*i;
        }
        System.out.println("Factorial of "+num" is: "+factorial);
    }
}