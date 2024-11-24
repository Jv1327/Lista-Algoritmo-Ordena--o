import java.util.Arrays;

public class StringSortingAndSearch {

    public static void main(String[] args) {
        String[] words = {"banana", "apple", "grape", "kiwi", "orange"};
        
        System.out.println("Antes da ordenação:");
        System.out.println(Arrays.toString(words));

        // Ordenando com Merge Sort
        mergeSort(words, 0, words.length - 1);
        System.out.println("Após ordenação (Merge Sort):");
        System.out.println(Arrays.toString(words));

        // Ordenando com Quick Sort
        String[] wordsForQuickSort = {"banana", "apple", "grape", "kiwi", "orange"};
        quickSort(wordsForQuickSort, 0, wordsForQuickSort.length - 1);
        System.out.println("Após ordenação (Quick Sort):");
        System.out.println(Arrays.toString(wordsForQuickSort));

        // Procurando por uma palavra usando Binary Search
        String key = "kiwi";
        int index = binarySearch(words, key);
        System.out.println("A palavra '" + key + "' foi encontrada no índice: " + index);
    }

    // Implementação de Merge Sort para Strings
    public static void mergeSort(String[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(String[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        String[] L = new String[n1];
        String[] R = new String[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Implementação de Quick Sort para Strings
    public static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Implementação de Binary Search para Strings
    public static int binarySearch(String[] arr, String key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = arr[mid].compareTo(key);
            if (result == 0) return mid;
            if (result < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}