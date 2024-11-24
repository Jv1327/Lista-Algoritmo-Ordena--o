import java.util.Arrays;

public class InterpolationSearch {
    /**
     * Realiza a busca Interpolation Search em um array ordenado.
     * @param arr Array de inteiros ordenado.
     * @param target Elemento a ser buscado.
     * @return Índice do elemento encontrado, ou -1 se não encontrado.
     */
    public static int interpolationSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            // Calcula o índice de previsão com base na fórmula de interpolação
            int pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            // Verifica se encontramos o alvo
            if (arr[pos] == target) {
                return pos; // Elemento encontrado no índice pos
            }

            // Ajusta os limites da busca
            if (arr[pos] < target) {
                low = pos + 1; // Move a busca para a parte direita
            } else {
                high = pos - 1; // Move a busca para a parte esquerda
            }
        }
        return -1; // Retorna -1 se o elemento não for encontrado
    }

    /**
     * Método principal para demonstrar o funcionamento do Interpolation Search.
     */
    public static void main(String[] args) {
        // Array ordenado necessário para o Interpolation Search funcionar
        int[] sortedArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int target = 70;

        System.out.println("Array ordenado: " + Arrays.toString(sortedArray));

        // Busca o elemento escolhido na lista ordenada
        int index = interpolationSearch(sortedArray, target);

        // Exibe o resultado da busca
        if (index != -1) {
            System.out.println("Elemento " + target + " encontrado no índice " + index + ".");
        } else {
            System.out.println("Elemento " + target + " não encontrado.");
        }

        /**
         * Explicação:
         * 
         * O Interpolation Search funciona de maneira semelhante ao Binary Search, mas ao invés de
         * dividir o array ao meio, ele tenta calcular a posição mais provável do elemento,
         * baseando-se no valor do elemento alvo. Isso é feito utilizando uma fórmula de interpolação
         * que leva em consideração os valores de low, high e o valor alvo.
         *
         * Vantagens:
         * 
         * - Mais eficiente que a busca binária em listas ordenadas com intervalos uniformes.
         * - Em listas com intervalos mais uniformes, a busca pode ser mais rápida.
         *
         * Desvantagens:
         * 
         * - Menos eficiente se os valores do array não forem uniformemente distribuídos.
         * - Requer que o array esteja ordenado.
         */
    }
}