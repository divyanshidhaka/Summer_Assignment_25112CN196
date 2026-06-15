

public class ReverseTheArray {
    static void ReverseArray(int[] arr){
        int size = arr.length;
        for(int i =0,j = size-1; i<=j ; i++,j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        for(int k: arr){
            System.out.print(k+"\t");
        }
    }


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};

        ReverseArray(array);
        
    }
}
