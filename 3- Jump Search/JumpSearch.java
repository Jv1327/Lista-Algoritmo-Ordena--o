import java.util.Arrays;

public class JumpSearch {
    /**
     * Realiza a busca Jump Search em um array ordenado.
     * @param arr Array de inteiros ordenado.
     * @param target Elemento a ser buscado.
     * @return Índice do elemento encontrado, ou -1 se não encontrado.
     */
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length; // Tamanho do array
        int step = (int) Math.sqrt(n); // Define o tamanho do "salto" ideal como a raiz quadrada do tamanho do array
        int prev = 0; // Marca o início do bloco de busca

        // Realiza os "saltos" até encontrar um bloco onde o alvo pode estar
        while (arr[Math.min(step, n) - 1] < target) {
            prev = step; // Avança para o próximo bloco
            step += (int) Math.sqrt(n); // Atualiza o próximo limite de salto
            if (prev >= n) {
                return -1; // Elemento não encontrado
            }
        }

        // Realiza busca linear dentro do bloco onde o alvo pode estar
        while (arr[prev] < target) {
            prev++;
            if (prev == Math.min(step, n)) {
                return -1; // Alvo não está no bloco
            }
        }

        // Verifica se o elemento foi encontrado
        if (arr[prev] == target) {
            return prev;
        }

        return -1; // Elemento não encontrado
    }

    /**
     * Método principal para demonstrar o funcionamento do Jump Search.
     */
    public static void main(String[] args) {
        // Array ordenado necessário para o Jump Search funcionar
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31};
        int target = 15;

        System.out.println("Array ordenado: " + Arrays.toString(sortedArray));

        // Busca o elemento alvo na lista ordenada
        int index = jumpSearch(sortedArray, target);

        // Exibe o resultado da busca
        if (index != -1) {
            System.out.println("Elemento " + target + " encontrado no índice " + index + ".");
        } else {
            System.out.println("Elemento " + target + " não encontrado.");
        }

        /**
         * Explicação:
         * 
         * O Jump Search funciona ao dividir a lista em blocos de tamanho igual à raiz quadrada
         * do tamanho do array. Ele "salta" entre os blocos para encontrar aquele onde o
         * elemento alvo pode estar. Após identificar o bloco correto, uma busca linear é feita
         * dentro do bloco para localizar o elemento.
         *
         * Vantagens:
         * 
         * - Mais eficiente que a busca linear para listas grandes.
         *
         * Desvantagens:
         * 
         * - Requer que o array esteja ordenado.
         * - Em listas pequenas, o desempenho pode ser similar ou pior do que o da busca linear.
         */
    }
}