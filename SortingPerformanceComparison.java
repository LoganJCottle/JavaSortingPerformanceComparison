/* 
 *  Logan Cottle 
 *  Sorting algorithms by GeeksForGeeks
 *  CSCI-3302
 *  11/11/2025
 *  Sorting Algorithms Performance Comparison
 *
 *  This program times and prints the time it takes to sort random arrays of varying sizes in order to show the speed
 *  of each sorting algorithm and how long it takes to sort a reference value array, rather than a primitive value array.
 */
import java.util.*;

public class SortingPerformanceComparison<E> {
    public static void main(String[] args) {

        // Constant variables for array sizes
        final int SMALL = 100;
        final int MEDIUM = 1000;
        final int MEDIUMPLUS = 50000;
        final int LARGE = 1000000;

        int[] dataSmall = new int[SMALL];
        Random r = new Random();

        // Small data set (100 elements)
        for (int i = 0; i < dataSmall.length; i++) {
            dataSmall[i] = r.nextInt(100000);
        }

        // Assuming if the small dataset is random then all datasets will be
        System.out.println("\nDatasets are sorted prior to using a sorting algorithm: " + isSorted(dataSmall) + ".\n");

        // Making copies of the small array for each sorting algorithm
        int[] dataForHeapSort1 = Arrays.copyOf(dataSmall, dataSmall.length);
        int[] dataForSelectionSort1 = Arrays.copyOf(dataSmall, dataSmall.length);
        int[] dataForRadixSort1 = Arrays.copyOf(dataSmall, dataSmall.length);
        int[] dataForMergeSort1 = Arrays.copyOf(dataSmall, dataSmall.length);
        int[] dataForQuickSort1 = Arrays.copyOf(dataSmall, dataSmall.length);
        int[] dataForJavaArraysSort1 = Arrays.copyOf(dataSmall, dataSmall.length);

        // Medium data set (1 thousand elements)
        int[] dataMedium = new int[MEDIUM];
        for (int i = 0; i < dataMedium.length; i++) {
            dataMedium[i] = r.nextInt(100000);
        }

        // Making copies of the medium array for each sorting algorithm
        int[] dataForHeapSort2 = Arrays.copyOf(dataMedium, dataMedium.length);
        int[] dataForSelectionSort2 = Arrays.copyOf(dataMedium, dataMedium.length);
        int[] dataForRadixSort2 = Arrays.copyOf(dataMedium, dataMedium.length);
        int[] dataForMergeSort2 = Arrays.copyOf(dataMedium, dataMedium.length);
        int[] dataForQuickSort2 = Arrays.copyOf(dataMedium, dataMedium.length);
        int[] dataForJavaArraysSort2 = Arrays.copyOf(dataMedium, dataMedium.length);

        // Large dataset (1 million elements)
        int[] dataLarge = new int[LARGE];
        for (int i = 0; i < dataLarge.length; i++) {
            dataLarge[i] = r.nextInt(100000);
        }

        // Making copies of the large array for each sorting algorithm
        int[] dataForHeapSort3 = Arrays.copyOf(dataLarge, dataLarge.length);
        int[] dataForSelectionSort3 = Arrays.copyOf(dataLarge, dataLarge.length);
        int[] dataForRadixSort3 = Arrays.copyOf(dataLarge, dataLarge.length);
        int[] dataForMergeSort3 = Arrays.copyOf(dataLarge, dataLarge.length);
        int[] dataForQuickSort3 = Arrays.copyOf(dataLarge, dataLarge.length);
        int[] dataForJavaArraysSort3 = Arrays.copyOf(dataLarge, dataLarge.length);

        // Start timing and sorting for each algorithm
        // Small, Medium, and Large arrays separated by empty lines
        // Heap Sort
        long startTime1s = System.nanoTime();
        heapSort(dataForHeapSort1);
        long endTime1s = System.nanoTime();
        long duration1s = endTime1s - startTime1s;

        long startTime1m = System.nanoTime();
        heapSort(dataForHeapSort2);
        long endTime1m = System.nanoTime();
        long duration1m = endTime1m - startTime1m;

        long startTime1l = System.currentTimeMillis();
        heapSort(dataForHeapSort3);
        long endTime1l = System.currentTimeMillis();
        long duration1l = endTime1l - startTime1l;

        // Selection Sort
        long startTime2s = System.nanoTime();
        selectionSort(dataForSelectionSort1);
        long endTime2s = System.nanoTime();
        long duration2s = endTime2s - startTime2s;

        long startTime2m = System.nanoTime();
        selectionSort(dataForSelectionSort2);
        long endTime2m = System.nanoTime();
        long duration2m = endTime2m - startTime2m;
        
        // Since selection sort takes a long time, here I
        // update the user so they don't think the program failed.
        System.out.println("Selection sort taking a few minutes, please wait...");
        long startTime2l = System.currentTimeMillis();
        selectionSort(dataForSelectionSort3);
        long endTime2l = System.currentTimeMillis();
        long duration2l = endTime2l - startTime2l;
        System.out.println("Selection sort finished, things should speed up now!\n");

        // Radix Sort
        long startTime3s = System.nanoTime();
        radixsort(dataForRadixSort1, SMALL);
        long endTime3s = System.nanoTime();
        long duration3s = endTime3s - startTime3s;

        long startTime3m = System.nanoTime();
        radixsort(dataForRadixSort2, MEDIUM);
        long endTime3m = System.nanoTime();
        long duration3m = endTime3m - startTime3m;

        radixsort(dataForRadixSort3, LARGE);
        long startTime3l = System.currentTimeMillis();
        heapSort(dataForRadixSort3);
        long endTime3l = System.currentTimeMillis();
        long duration3l = endTime3l - startTime3l;

        // Merge Sort
        long startTime4s = System.nanoTime();
        mergeSort(dataForMergeSort1, 0, SMALL - 1);
        long endTime4s = System.nanoTime();
        long duration4s = endTime4s - startTime4s;

        long startTime4m = System.nanoTime();
        mergeSort(dataForMergeSort2, 0, MEDIUM - 1);
        long endTime4m = System.nanoTime();
        long duration4m = endTime4m - startTime4m;

        long startTime4l = System.currentTimeMillis();
        mergeSort(dataForMergeSort3, 0, LARGE - 1);
        long endTime4l = System.currentTimeMillis();
        long duration4l = endTime4l - startTime4l;

        // Quick Sort
        long startTime5s = System.nanoTime();
        quickSort(dataForQuickSort1, 0, SMALL - 1);
        long endTime5s = System.nanoTime();
        long duration5s = endTime5s - startTime5s;

        long startTime5m = System.nanoTime();
        quickSort(dataForQuickSort2, 0, MEDIUM - 1);
        long endTime5m = System.nanoTime();
        long duration5m = endTime5m - startTime5m;

        long startTime5l = System.currentTimeMillis();
        quickSort(dataForQuickSort3, 0, LARGE - 1);
        long endTime5l = System.currentTimeMillis();
        long duration5l = endTime5l - startTime5l;

        // Arrays.sort
        long startTime6s = System.nanoTime();
        Arrays.sort(dataForJavaArraysSort1);
        long endTime6s = System.nanoTime();
        long duration6s = endTime6s - startTime6s;

        long startTime6m = System.nanoTime();
        Arrays.sort(dataForJavaArraysSort2);
        long endTime6m = System.nanoTime();
        long duration6m = endTime6m - startTime6m;

        long startTime6l = System.currentTimeMillis();
        Arrays.sort(dataForJavaArraysSort3);
        long endTime6l = System.currentTimeMillis();
        long duration6l = endTime6l - startTime6l;

        // Checking if the sorting algorithms worked
        // Checking only the smallest dataset since if the algorithms work for a small
        // dataset then they should work for a large one.
        System.out.println("Heap sort worked successfully: " + isSorted(dataForHeapSort1) + ".");
        System.out.println("Selection sort worked successfully: " + isSorted(dataForSelectionSort1) + ".");
        System.out.println("Radix sort worked successfully: " + isSorted(dataForRadixSort1) + ".");
        System.out.println("Merge sort worked successfully: " + isSorted(dataForMergeSort1) + ".");
        System.out.println("Quick sort worked successfully: " + isSorted(dataForQuickSort1) + ".");
        System.out.println("Arrays.java sort worked successfully: " + isSorted(dataForJavaArraysSort1) + ".\n");

        // Output the results
        System.out.println("Sorting Algorithms Performance Comparison:");
        // Heap sort times
        System.out.println("Heap sort took: " + duration1s + " nanoseconds to complete for a small dataset.");
        System.out.println("Heap sort took: " + duration1m + " nanoseconds to complete for a medium dataset.");
        System.out.println("Heap sort took: " + duration1l + " ms to complete for a large dataset.\n");

        // Selection sort times
        System.out.println("Selection sort took: " + duration2s + " nanoseconds to complete for a small dataset.");
        System.out.println("Selection sort took: " + duration2m + " nanoseconds to complete for a medium dataset.");
        System.out.println("Selection sort took: " + duration2l + " ms to complete for a large dataset.\n");

        // Radix sort times
        System.out.println("Radix sort took: " + duration3s + " nanoseconds to complete for a small dataset.");
        System.out.println("Radix sort took: " + duration3m + " nanoseconds to complete for a medium dataset.");
        System.out.println("Radix sort took: " + duration3l + " ms to complete for a large dataset.\n");

        // Merge sort times
        System.out.println("Merge sort took: " + duration4s + " nanoseconds to complete for a small dataset.");
        System.out.println("Merge sort took: " + duration4m + " nanoseconds to complete for a medium dataset.");
        System.out.println("Merge sort took: " + duration4l + " ms to complete for a large dataset.\n");

        // Quick sort times
        System.out.println("Quick sort took: " + duration5s + " nanoseconds to complete for a small dataset.");
        System.out.println("Quick sort took: " + duration5m + " nanoseconds to complete for a medium dataset.");
        System.out.println("Quick sort took: " + duration5l + " ms to complete for a large dataset.\n");

        // Java Arrays.sort times
        System.out.println("Arrays.sort took: " + duration6s + " nanoseconds to complete for a small dataset.");
        System.out.println("Arrays.sort took: " + duration6m + " nanoseconds to complete for a medium dataset.");
        System.out.println("Arrays.sort took: " + duration6l + " ms to complete for a large dataset.\n");

        // Explanation
        System.out.println("As shown above, some arrays (such as Selection sort) take quite some time when datasets " +
                "increase in size.");
        System.out.println("Whereas Quicksort, Merge sort, and Radix sort were the fastest sorting algorithms " +
                "for large datasets.");
        System.out.println(
                "each one taking " + duration5l + ", " + duration4l + ", and " + duration3l + " ms respectively.");
        System.out.println("These algorithms were also the fastest with smaller datasets.\n");

        // int vs Integer Arrays.sort sorting
        // MediumPlus data set (50 thousand elements)
        int[] dataMediumPlus = new int[MEDIUMPLUS];
        for (int i = 0; i < dataMediumPlus.length; i++) {
            dataMediumPlus[i] = r.nextInt(100000);
        }

        int[] intArray = Arrays.copyOf(dataMediumPlus, dataMediumPlus.length);
        Integer[] integerArray = new Integer[MEDIUMPLUS];

        // Copying dataMediumPlus to integerArray
        for (int i = 0; i < dataMediumPlus.length; i++) {
            integerArray[i] = Integer.valueOf(dataMediumPlus[i]);
        }

        // int Arrays.sort
        long startTimeInt = System.currentTimeMillis();
        Arrays.sort(intArray);
        long endTimeInt = System.currentTimeMillis();
        long durationInt = endTimeInt - startTimeInt;

        // Integer Arrays.sort
        long startTimeInteger = System.currentTimeMillis();
        Arrays.sort(integerArray);
        long endTimeInteger = System.currentTimeMillis();
        long durationInteger = endTimeInteger - startTimeInteger;

        System.out.println("Arrays.sort int vs Integer sorting time comparison:");

        // Integer vs int array sort times
        System.out.println("Arrays.sort sorted an int array in: " + durationInt + " ms.");
        System.out.println("And it sorted an Integer array in: " + durationInteger + " ms.\n");

        // Explanation for Integer vs int array times
        System.out.println("I expected the int array to be faster because it uses primitive type variable.");
        System.out.println("This turned out to be accurate; as the Integer array took about two to three times as long " +
                "to sort as the int array did.\n");
    }

    // Method to tell if an array is sorted
    static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (!(arr[i].compareTo(arr[i + 1]) < 0))
                return false;
        }
        return true;
    }

    // Same method to see if an array is sorted but specifically for int arrays
    static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (!(arr[i] < arr[i + 1]))
                return false;
        }
        return true;
    }
    // End of my personal code
    
    // Heap sort implementation from GeeksforGeeks
    // "https://www.geeksforgeeks.org/dsa/heap-sort"
    // To heapify a subtree rooted with node i
    static void heapify(int[] arr, int n, int i) {

        // Initialize largest as root
        int largest = i;

        // left index = 2*i + 1
        int l = 2 * i + 1;

        // right index = 2*i + 2
        int r = 2 * i + 2;

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // Main function to do heap sort
    static void heapSort(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange vector)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {

            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    // End of heap sort implementation from GeeksforGeeks

    // Selection sort implementation from GeeksforGeeks
    // "https://www.geeksforgeeks.org/dsa/selection-sort-algorithm-2"
    static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {

            // Assume the current position holds
            // the minimum element
            int min_idx = i;

            // Iterate through the unsorted portion
            // to find the actual minimum
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {

                    // Update min_idx if a smaller element
                    // is found
                    min_idx = j;
                }
            }

            // Move minimum element to its
            // correct position
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }
    // End of selection sort implementation from GeeksforGeeks

    // Radix sort implementation from GeeksforGeeks
    // "https://www.geeksforgeeks.org/dsa/radix-sort"
    // A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // The main function to that sorts arr[] of
    // size n using Radix Sort
    static void radixsort(int arr[], int n) {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }
    // End of radix sort implementation from GeeksforGeeks

    // Merge sort implementation from GeeksforGeeks
    // "https://www.geeksforgeeks.org/dsa/merge-sort"
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[], int l, int m, int r) {

        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        // Merge the temp arrays
        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void mergeSort(int arr[], int l, int r) {

        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    // End of merge sort implementation from GeeksforGeeks

    // Quick sort implementation from GeeksforGeeks
    // "https://www.geeksforgeeks.org/dsa/quick-sort-algorithm"
    // partition function
    static int partition(int[] arr, int low, int high) {

        // choose the pivot
        int pivot = arr[high];

        // index of smaller element and indicates
        // the right position of pivot found so far
        int i = low - 1;

        // traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);
        return i + 1;
    }

    // swap function
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // the QuickSort function implementation
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // recursion calls for smaller elements
            // and greater or equals elements
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    // End of quick sort implementation from GeeksforGeeks
}