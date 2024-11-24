import java.util.Arrays;

public class QuickSort {
    /**
     * Realiza a ordenação de um array utilizando o algoritmo Quick Sort.
     * @param arr Array de inteiros a ser ordenado.
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * Realiza a ordenação recursiva do Quick Sort.
     * @param arr Array de inteiros a ser ordenado.
     * @param low Índice inferior do subarray a ser ordenado.
     * @param high Índice superior do subarray a ser ordenado.
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // Pivô

            // Ordena as duas partes separadas pelo pivô
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Realiza a partição do array e retorna o índice do pivô.
     * @param arr Array de inteiros.
     * @param low Índice inferior do subarray.
     * @param high Índice superior do subarray.
     * @return Índice do pivô.
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // O último elemento é escolhido como pivô
        int i = (low - 1); // Índice do menor elemento

        // Organiza os elementos para que os menores que o pivô fiquem à esquerda e os maiores à direita
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Coloca o pivô na posição correta
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * Método principal para demonstrar o funcionamento do Quick Sort.
     */
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        System.out.println("Array antes da ordenação: " + Arrays.toString(arr));

        // Ordena o array utilizando Quick Sort
        quickSort(arr);

        System.out.println("Array após a ordenação: " + Arrays.toString(arr));

        /**
         * Explicação:
         * 
         * O Quick Sort é um algoritmo de ordenação baseado em divisão e conquista. Ele escolhe um pivô e reorganiza
         * os elementos para que os menores fiquem à esquerda e os maiores fiquem à direita. Em seguida, a ordenação é realizada
         * recursivamente nas sublistas formadas pelos elementos menores e maiores que o pivô.
         *
         * Vantagens:
         * 
         * - Complexidade de tempo média O(n log n), o que o torna muito eficiente para grandes listas.
         * - Desempenho muito bom em listas quase ordenadas.
         *
         * Desvantagens:
         * 
         * - No pior caso (quando o pivô escolhido é o menor ou maior elemento), a complexidade pode ser O(n^2).
         * - A escolha do pivô afeta o desempenho. Estratégias como "pivô aleatório" ou "pivô do meio" podem ser usadas
         *   para evitar o pior caso.
         */
    }
}