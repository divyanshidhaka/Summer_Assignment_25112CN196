public class FrequencyOfAnElement {
    public static int Frequency(int[] arr, int num){
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == num){
                count++;
            }
        }
        return count;
    } 

    public static void main(String[] args) {
        int[] arr = {3,4,4,2,4,5,7,4,8,4};
        int num = 4;
        System.out.println(Frequency(arr, num));
    }
}
