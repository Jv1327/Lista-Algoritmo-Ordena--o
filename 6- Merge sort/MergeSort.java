import java.util.Arrays;

public class MergeSort {
    /**
     * Realiza a ordenação de um array utilizando o algoritmo Merge Sort.
     * @param arr Array de inteiros a ser ordenado.
     */
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return; // Retorna se o array já tiver 0 ou 1 elemento
        }

        // Divide o array ao meio
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid); // Subarray da esquerda
        int[] right = Arrays.copyOfRange(arr, mid, arr.length); // Subarray da direita

        // Ordena as duas metades
        mergeSort(left);
        mergeSort(right);

        // Mescla as duas metades ordenadas
        merge(arr, left, right);
    }

    /**
     * Mescla dois subarrays ordenados em um único array ordenado.
     * @param arr Array original que receberá a ordenação.
     * @param left Subarray da esquerda.
     * @param right Subarray da direita.
     */
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Mescla os elementos enquanto há elementos em ambos os subarrays
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++]; // Adiciona o menor elemento
            } else {
                arr[k++] = right[j++]; // Adiciona o menor elemento
            }
        }

        // Adiciona os elementos restantes de left, se houver
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Adiciona os elementos restantes de right, se houver
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    /**
     * Método principal para demonstrar o funcionamento do Merge Sort.
     */
    public static void main(String[] args) {
        int[] arr = {34, 8, 64, 51, 32, 65, 21, 91};

        System.out.println("Array antes da ordenação: " + Arrays.toString(arr));

        // Ordena o array utilizando Merge Sort
        mergeSort(arr);

        System.out.println("Array após a ordenação: " + Arrays.toString(arr));

        /**
         * Explicação:
         * 
         * O Merge Sort é um algoritmo de ordenação baseado na técnica de "dividir para conquistar".
         * Ele divide recursivamente o array em duas metades até que cada subarray tenha um único elemento,
         * e então começa a mesclar os subarrays de volta em uma ordem ordenada. A eficiência vem do fato de
         * que as divisões reduzem o número de comparações necessárias nas etapas posteriores.
         *
         * Vantagens:
         * 
         * - Complexidade de tempo O(n log n) no pior caso.
         * - Estável, não altera a ordem relativa de elementos iguais.
         *
         * Desvantagens:
         * 
         * - Requer espaço adicional O(n) para armazenar os subarrays temporários.
         * - Menos eficiente em arrays pequenos em comparação com algoritmos como Quick Sort.
         */
    }
}