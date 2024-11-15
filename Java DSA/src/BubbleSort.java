// import java.util.Random;

public class BubbleSort {

    // Method to perform bubble sort on an array
    static void bubbleSort(int[] list) {
        int length = list.length;
        // Outer loop to traverse through all elements
        for (int i = 0; i < length; i++) {
            boolean conti_flag = false;
            // Inner loop for comparing adjacent elements
            for (int j = 0; j < (length - i) - 1; j++) {
                // Swap if the element found is greater than the next element
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    conti_flag = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!conti_flag)
                break;
        }

    }

    static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            // Move elements of array[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) { // Iterate over the array
            int minIndex = i; // Assume the current index is the minimum
            for (int j = i + 1; j < n; j++) { // Find the minimum element in the remaining array
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Update the index of the minimum element
                }
            }
            // Swap the found minimum element with the first/ith element
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    static void quickSort(int[] list, int fst, int lst) {
        if (fst >= lst)
            return;

        int i = fst;
        int j = lst;

        // Generate a random pivot index between fst and lst
        // Random random = new Random();
        // int pivotIndex = fst + random.nextInt(lst - fst + 1);
        // int pivot = list[pivotIndex];

        int pivotIndex = fst + (lst - fst) / 2;
        int pivot = list[pivotIndex];
        while (i <= j) {
            while (list[i] < pivot)
                i++;
            while (list[j] > pivot)
                j--;

            if (i <= j) {
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i++;
                j--;
            }
        }

        quickSort(list, fst, j);
        quickSort(list, i, lst);
    }

    public static void main(String[] args) {
        // Initialize an array with unsorted elements
        int[] list = { 10, 23, 21, 2, 4, 6, 3, 0 ,234,2134,2431,5,753,};
        // Call bubbleSort method to sort the array
        // bubbleSort(list);
        // insertionSort(list);
        // selectionSort(list);
        quickSort(list, 0, list.length - 1);
        // Create a StringBuilder to format the sorted array as a string
        StringBuilder str = new StringBuilder("[");
        // Append each element of the sorted array to the StringBuilder
        for (int i = 0; i < list.length; i++) {
            str.append(list[i]).append(", ");
        }
        // Remove the last comma and space
        str.setLength(str.length() - 2);
        // Append closing bracket
        str.append("]");
        // Print the sorted array
        System.out.println(str);
    }
}
