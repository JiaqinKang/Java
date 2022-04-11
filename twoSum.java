import java.util.ArrayList;
import java.util.Arrays;

public class twoSum {

    //brute force method
    public static int [] arrayTwoSum(int[] arr, int target) {
        // find position of two elements that sums the target
        // return the position of the two elements in the array
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    //list check method
    public static int [] listCheckTwoSum (int [] arr, int target) {
        ArrayList<String> list = new ArrayList<>();
        for (int j : arr) {
            list.add(String.valueOf(j));
        }
        for (int i = 0; i < list.size(); i++) {
            String targetString = String.valueOf(target - arr[i]);
            if (list.contains(targetString)) {
                return new int[]{i, list.indexOf(targetString)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //generate an array filled with random numbers with given length
    public static int [] getRandomNumberSizeArray(int length, int max) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * max);
        }
        return arr;
    }

    //testing section
    public static void main(String[] args) {
        int[] array = getRandomNumberSizeArray(10, 10);

//        int [] array = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(array));
        System.out.println("target: " + target);
        System.out.println("brute Force position: " + Arrays.toString(arrayTwoSum(array, target)));
        System.out.println("arrayList check target position: " + Arrays.toString(listCheckTwoSum(array, target)));
    }
}
