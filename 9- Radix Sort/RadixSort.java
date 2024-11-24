import java.util.Arrays;

public class RadixSort {
    /**
     * Realiza a ordenação de um array de inteiros utilizando o algoritmo Radix Sort.
     * @param arr Array de inteiros a ser ordenado.
     */
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt(); // Encontra o maior número no array

        // Realiza a ordenação por dígitos (começando pelo menor dígito)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp); // Ordena por dígito específico (unidades, dezenas, etc.)
        }
    }

    /**
     * Ordena o array utilizando o Counting Sort com base em um dígito específico.
     * @param arr Array de inteiros a ser ordenado.
     * @param exp O dígito a ser utilizado na ordenação (ex.: unidades, dezenas, etc.)
     */
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Array de saída
        int[] count = new int[10]; // Contagem dos dígitos (0 a 9)

        // Contagem dos dígitos no array
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Ajusta a contagem para armazenar as posições dos elementos
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Preenche o array de saída com os elementos ordenados por dígito
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copia o array de saída para o array original
        System.arraycopy(output, 0, arr, 0, n);
    }

    /**
     * Método principal para demonstrar o funcionamento do Radix Sort.
     */
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.println("Array antes da ordenação: " + Arrays.toString(arr));

        // Ordena o array utilizando Radix Sort
        radixSort(arr);

        System.out.println("Array após a ordenação: " + Arrays.toString(arr));

        /**
         * Explicação:
         * 
         * O Radix Sort é um algoritmo de ordenação que organiza os números com base em seus dígitos. A ordenação é feita
         * de forma estável por cada dígito (começando pelas unidades, depois dezenas, centenas, etc.), utilizando o Counting Sort
         * para cada dígito.
         *
         * Vantagens:
         * 
         * - Tem uma complexidade linear O(nk), onde n é o número de elementos e k é o número de dígitos do maior número.
         * - Eficiente quando os números têm um número fixo de dígitos ou quando o intervalo de valores é limitado.
         *
         * Desvantagens:
         * 
         * - Requer mais espaço adicional para o array de contagem.
         * - Não é adequado para ordenar números com uma grande quantidade de dígitos ou números de ponto flutuante.
         */
    }
}