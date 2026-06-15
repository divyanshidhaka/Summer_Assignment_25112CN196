public class RightRotateArray {
    static void ShiftBy1(int[] arr){
        int size = arr.length;
        int temp = arr[size-1];

        for(int i = size-1; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;

        for(int i = 0;i<size;i++){
            System.out.print(arr[i]+"\t");
        }
    }

    public static void main(String[] args) {
       int[] arr = {1,2,3,4,5,6,7};
       ShiftBy1(arr);
}
}