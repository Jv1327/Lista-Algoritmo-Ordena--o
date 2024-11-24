import java.util.Arrays;

public class SortComparison {

    public static void main(String[] args) {
        int[] smallArray = {5, 2, 9, 1, 5, 6};
        int[] mediumArray = {5, 3, 8, 6, 7, 9, 1, 2, 4};
        int[] largeArray = new int[10000];
        
        // Preenchendo o array grande com números aleatórios
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = (int)(Math.random() * 100);
        }

        System.out.println("Testando Shell Sort:");
        testSort("Shell Sort", smallArray);
        testSort("Shell Sort", mediumArray);
        testSort("Shell Sort", largeArray);

        System.out.println("Testando Merge Sort:");
        testSort("Merge Sort", smallArray);
        testSort("Merge Sort", mediumArray);
        testSort("Merge Sort", largeArray);

        System.out.println("Testando Selection Sort:");
        testSort("Selection Sort", smallArray);
        testSort("Selection Sort", mediumArray);
        testSort("Selection Sort", largeArray);

        System.out.println("Testando Quick Sort:");
        testSort("Quick Sort", smallArray);
        testSort("Quick Sort", mediumArray);
        testSort("Quick Sort", largeArray);

        System.out.println("Testando Bucket Sort:");
        testSort("Bucket Sort", smallArray);
        testSort("Bucket Sort", mediumArray);
        testSort("Bucket Sort", largeArray);

        System.out.println("Testando Radix Sort:");
        testSort("Radix Sort", smallArray);
        testSort("Radix Sort", mediumArray);
        testSort("Radix Sort", largeArray);
    }

    /**
     * Testa e exibe o tempo de execução de um algoritmo de ordenação.
     *
     * @param algorithm Nome do algoritmo de ordenação.
     * @param arr Array a ser ordenado.
     */
    public static void testSort(String algorithm, int[] arr) {
        long startTime = System.nanoTime();

        switch (algorithm) {
            case "Shell Sort":
                shellSort(arr);
                break;
            case "Merge Sort":
                mergeSort(arr, 0, arr.length - 1);
                break;
            case "Selection Sort":
                selectionSort(arr);
                break;
            case "Quick Sort":
                quickSort(arr, 0, arr.length - 1);
                break;
            case "Bucket Sort":
                bucketSort(arr);
                break;
            case "Radix Sort":
                radixSort(arr);
                break;
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(algorithm + " durou: " + duration + " nanosegundos");
    }

    // Implementação simplificada de Shell Sort
    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    // Implementação simplificada de Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Implementação simplificada de Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // Implementação simplificada de Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Implementação simplificada de Bucket Sort
    public static void bucketSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }

    // Implementação simplificada de Radix Sort
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }
}