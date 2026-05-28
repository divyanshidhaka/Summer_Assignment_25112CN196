import java.util.Scanner;
public SumOfNaturalNumber {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();

        int sum = 0;
        for(int i = 1; i<=num;i++){
            sum+=i;
        }
        System.out.println("The Sum Of first "+num+ "Natural Number is : "+ sum);
    }
}