import java.util.Arrays;

public class SearchComparison {

    public static void main(String[] args) {
        int[] smallArray = {1, 3, 5, 7, 9, 11};
        int[] mediumArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
        int[] largeArray = new int[100000];
        
        // Preenchendo o array grande com números sequenciais
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = i * 2;
        }

        int key = 15;

        // Comparando os tempos de execução
        System.out.println("Testando Binary Search:");
        testSearch("Binary Search", smallArray, key);
        testSearch("Binary Search", mediumArray, key);
        testSearch("Binary Search", largeArray, key);
        
        System.out.println("Testando Interpolation Search:");
        testSearch("Interpolation Search", smallArray, key);
        testSearch("Interpolation Search", mediumArray, key);
        testSearch("Interpolation Search", largeArray, key);
        
        System.out.println("Testando Jump Search:");
        testSearch("Jump Search", smallArray, key);
        testSearch("Jump Search", mediumArray, key);
        testSearch("Jump Search", largeArray, key);
        
        System.out.println("Testando Exponential Search:");
        testSearch("Exponential Search", smallArray, key);
        testSearch("Exponential Search", mediumArray, key);
        testSearch("Exponential Search", largeArray, key);
    }

    /**
     * Testa e exibe o tempo de execução de um algoritmo de busca.
     * 
     * @param algorithm Nome do algoritmo de busca.
     * @param arr Array no qual a busca será realizada.
     * @param key O valor a ser buscado.
     */
    public static void testSearch(String algorithm, int[] arr, int key) {
        long startTime = System.nanoTime();

        switch (algorithm) {
            case "Binary Search":
                binarySearch(arr, key);
                break;
            case "Interpolation Search":
                interpolationSearch(arr, key);
                break;
            case "Jump Search":
                jumpSearch(arr, key);
                break;
            case "Exponential Search":
                exponentialSearch(arr, key);
                break;
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(algorithm + " durou: " + duration + " nanosegundos");
    }

    // Implementação simplificada de Binary Search
    public static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] < key) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Implementação simplificada de Interpolation Search
    public static int interpolationSearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high && key >= arr[low] && key <= arr[high]) {
            int pos = low + ((high - low) / (arr[high] - arr[low])) * (key - arr[low]);
            if (arr[pos] == key) return pos;
            if (arr[pos] < key) low = pos + 1;
            else high = pos - 1;
        }
        return -1;
    }

    // Implementação simplificada de Jump Search
    public static int jumpSearch(int[] arr, int key) {
        int n = arr.length;
        int step = (int) Math.sqrt(n);
        int prev = 0;
        while (arr[Math.min(step, n) - 1] < key) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) return -1;
        }
        for (int i = prev; i < Math.min(step, n); i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }

    // Implementação simplificada de Exponential Search
    public static int exponentialSearch(int[] arr, int key) {
        if (arr[0] == key) return 0;
        int i = 1;
        while (i < arr.length && arr[i] <= key) {
            i = i * 2;
        }
        return binarySearch(Arrays.copyOfRange(arr, i / 2, Math.min(i, arr.length)), key);
    }
}