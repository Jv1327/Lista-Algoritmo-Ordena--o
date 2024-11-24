public class ComplexityAnalysis {

    public static void main(String[] args) {
        System.out.println("Análise de Complexidade de Algoritmos de Busca:");
        System.out.println("1. Binary Search: O(log n) - Melhor caso: O(1), Pior caso: O(log n), Espaço: O(1)");
        System.out.println("2. Interpolation Search: O(log log n) - Melhor caso: O(1), Pior caso: O(n), Espaço: O(1)");
        System.out.println("3. Jump Search: O(√n) - Melhor caso: O(1), Pior caso: O(√n), Espaço: O(1)");
        System.out.println("4. Exponential Search: O(log n) - Melhor caso: O(1), Pior caso: O(log n), Espaço: O(1)");

        System.out.println("\nAnálise de Complexidade de Algoritmos de Ordenação:");
        System.out.println("1. Shell Sort: O(n^3/2) (caso médio), O(n^2) (pior caso), O(n) (melhor caso com intervalo ideal), Espaço: O(1)");
        System.out.println("2. Merge Sort: O(n log n), Espaço: O(n)");
        System.out.println("3. Selection Sort: O(n^2), Espaço: O(1)");
        System.out.println("4. Quick Sort: O(n log n) (média), O(n^2) (pior caso), Espaço: O(log n)");
        System.out.println("5. Bucket Sort: O(n + k), onde k é o número de baldes, Espaço: O(n + k)");
        System.out.println("6. Radix Sort: O(nk), onde k é o número de dígitos, Espaço: O(n + k)");
    }
}
