//enhanced bubbleSort
public static void bubbleSortAscending(int[] arr) {

    for (int j = 2; j <= arr.length; j++) {

        for (int i = 0; i <= arr.length - j; i++) {

            if (arr[i] > arr[i + 1]) { 

                int c = arr[i];

                arr[i] = arr[i + 1];

                arr[i + 1] = c;

            }

        }

    }

}
