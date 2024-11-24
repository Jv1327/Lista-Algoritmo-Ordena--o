import java.util.Arrays;
import java.util.Scanner;

public class SearchSortComparison {

    // Função para calcular o tempo de execução
    public static long measureExecutionTime(Runnable method) {
        long startTime = System.nanoTime();
        method.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Algoritmos de ordenação
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Algoritmos de busca
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Função principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.println("Digite o tamanho do array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Preencha o array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Opções para o usuário
        System.out.println("Escolha um algoritmo de ordenação:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Quick Sort");
        int sortChoice = scanner.nextInt();

        // Executando o algoritmo de ordenação escolhido
        long sortTime = 0;
        switch (sortChoice) {
            case 1:
                sortTime = measureExecutionTime(() -> bubbleSort(arr));
                break;
            case 2:
                sortTime = measureExecutionTime(() -> selectionSort(arr));
                break;
            case 3:
                sortTime = measureExecutionTime(() -> quickSort(arr, 0, arr.length - 1));
                break;
            default:
                System.out.println("Opção inválida");
                return;
        }

        // Exibindo o tempo de ordenação
        System.out.println("Array ordenado: " + Arrays.toString(arr));
        System.out.println("Tempo de execução da ordenação (em nanossegundos): " + sortTime);

        // Opções para o usuário para busca
        System.out.println("Escolha um algoritmo de busca:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        int searchChoice = scanner.nextInt();

        // Procurar um elemento
        System.out.println("Digite o elemento para buscar:");
        int key = scanner.nextInt();

        // Usando um objeto para armazenar o resultado da busca
        final int[] searchResult = {-1};  // Valor inicial de -1, indicando que o valor não foi encontrado

        long searchTime = 0;
        switch (searchChoice) {
            case 1:
                searchTime = measureExecutionTime(() -> searchResult[0] = linearSearch(arr, key));
                break;
            case 2:
                searchTime = measureExecutionTime(() -> searchResult[0] = binarySearch(arr, key));
                break;
            default:
                System.out.println("Opção inválida");
                return;
        }

        // Exibindo o resultado da busca
        if (searchResult[0] != -1) {
            System.out.println("Elemento encontrado no índice: " + searchResult[0]);
        } else {
            System.out.println("Elemento não encontrado.");
        }

        // Exibindo o tempo de busca
        System.out.println("Tempo de execução da busca (em nanossegundos): " + searchTime);
    }
}