import java.util.Scanner;
public CountDigits{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        long num = input.nextLong();

        long temp = num;
        int count= 0;
        
        if(num==0){
            count = 1;
        }else{

            while(num>0){
                num = num/10;
                count++;

            }
        }
        System.out.println("The number of digits in "+temp+" is "+count);
    }
}