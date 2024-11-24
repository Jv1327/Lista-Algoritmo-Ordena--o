import java.util.Arrays;

public class BucketSort {
    /**
     * Realiza a ordenação de um array de números em ponto flutuante utilizando o algoritmo Bucket Sort.
     * @param arr Array de números em ponto flutuante.
     */
    public static void bucketSort(float[] arr) {
        int n = arr.length;
        
        if (n <= 0) return; // não faz nada se o array estiver vazio

        // Cria "baldes" para organizar os elementos
        @SuppressWarnings("unchecked")
        java.util.List<Float>[] buckets = new java.util.List[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new java.util.ArrayList<>();
        }

        // Distribui os elementos nos baldes com base em seu valor
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (arr[i] * n); // Calcula o índice do balde com base no valor do elemento
            buckets[bucketIndex].add(arr[i]);
        }

        // Ordena cada balde individualmente e coloca os elementos de volta no array
        for (int i = 0; i < n; i++) {
            java.util.Collections.sort(buckets[i]); // Ordena os baldes
            for (float num : buckets[i]) {
                arr[i++] = num; // Coloca os elementos ordenados no array original
            }
        }
    }

    /**
     * Método principal para demonstrar o funcionamento do Bucket Sort.
     */
    public static void main(String[] args) {
        float[] arr = {0.34f, 0.8f, 0.64f, 0.51f, 0.32f, 0.65f, 0.21f, 0.91f};

        System.out.println("Array antes da ordenação: " + Arrays.toString(arr));

        // Ordena o array utilizando Bucket Sort
        bucketSort(arr);

        System.out.println("Array após a ordenação: " + Arrays.toString(arr));

        /**
         * Explicação:
         * 
         * O Bucket Sort divide o array em baldes, com cada balde representando um intervalo de valores. Cada balde é
         * ordenado separadamente (geralmente por outro algoritmo como o Insertion Sort), e depois os baldes são
         * combinados para formar o array final ordenado.
         *
         * Vantagens:
         * 
         * - Eficiente para listas de números com uma distribuição uniforme.
         * - Pode ser mais eficiente que algoritmos O(n^2) como Selection Sort em casos específicos.
         *
         * Desvantagens:
         * 
         * - Depende da distribuição dos dados e pode ser ineficiente se os dados não forem distribuídos uniformemente.
         * - Requer espaço adicional para os baldes.
         */
    }
}