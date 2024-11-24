import java.util.Arrays;

public class StableSorting {
    // Função para ordenar utilizando Selection Sort (instável)
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Troca dos elementos
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Função para ordenar utilizando Bubble Sort (estável)
    public static void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Se não houve troca, o array já está ordenado
            if (!swapped) break;
        }
    }

    // Função para ordenar utilizando Merge Sort (estável)
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    // Função para imprimir o array
    public static void printArray(int[] arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Exemplo de um array com elementos iguais
        int[] array1 = {4, 2, 4, 1, 3};
        int[] array2 = {4, 2, 4, 1, 3};
        int[] array3 = {4, 2, 4, 1, 3};

        System.out.println("Array original: ");
        printArray(array1);

        // Demonstrando Selection Sort (instável)
        selectionSort(array1);
        System.out.println("Após Selection Sort (instável): ");
        printArray(array1);

        System.out.println("\nArray original: ");
        printArray(array2);

        // Demonstrando Bubble Sort (estável)
        bubbleSort(array2);
        System.out.println("Após Bubble Sort (estável): ");
        printArray(array2);

        System.out.println("\nArray original: ");
        printArray(array3);

        // Demonstrando Merge Sort (estável)
        mergeSort(array3);
        System.out.println("Após Merge Sort (estável): ");
        printArray(array3);
    }
}