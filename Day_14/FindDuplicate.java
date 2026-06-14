
public class FindDuplicate {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 4, 6, 10, 2};

        System.out.println("Duplicate elements found:");
        
       
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                
                if (arr[i] == arr[j]) {
                    System.out.println(arr[j]);
                    break;
                }
            }
        }
    }
}