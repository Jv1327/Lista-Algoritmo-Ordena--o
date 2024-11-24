import java.util.Arrays;
import java.util.Scanner;

public class StudentGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Notas dos alunos no intervalo [0, 100]
        double[] grades = {97.5, 82.4, 65.0, 90.3, 88.6, 75.2, 50.4, 92.1, 60.8, 85.0};

        // Exibição do menu para escolha do algoritmo
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Algoritmos de Ordenação");
        System.out.println("2 - Algoritmos de Busca");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Algoritmos de Ordenação
                System.out.println("Escolha o algoritmo de ordenação:");
                System.out.println("1 - Bucket Sort");
                System.out.println("2 - Merge Sort");
                int sortChoice = scanner.nextInt();

                long startTime, endTime;
                double[] gradesCopy;

                switch (sortChoice) {
                    case 1:
                        // Bucket Sort
                        gradesCopy = Arrays.copyOf(grades, grades.length);
                        System.out.println("Antes da ordenação: " + Arrays.toString(gradesCopy));
                        startTime = System.nanoTime();
                        bucketSort(gradesCopy);
                        endTime = System.nanoTime();
                        System.out.println("Após ordenação (Bucket Sort): " + Arrays.toString(gradesCopy));
                        System.out.println("Tempo de execução (Bucket Sort): " + (endTime - startTime) + " nanosegundos");
                        break;
                    case 2:
                        // Merge Sort
                        gradesCopy = Arrays.copyOf(grades, grades.length);
                        System.out.println("Antes da ordenação: " + Arrays.toString(gradesCopy));
                        startTime = System.nanoTime();
                        mergeSort(gradesCopy, 0, gradesCopy.length - 1);  // Corrigido para chamar mergeSort corretamente
                        endTime = System.nanoTime();
                        System.out.println("Após ordenação (Merge Sort): " + Arrays.toString(gradesCopy));
                        System.out.println("Tempo de execução (Merge Sort): " + (endTime - startTime) + " nanosegundos");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
                break;

            case 2:
                // Algoritmos de Busca
                System.out.println("Escolha o algoritmo de busca:");
                System.out.println("1 - Binary Search");
                System.out.println("2 - Interpolation Search");
                int searchChoice = scanner.nextInt();

                System.out.println("Digite a nota para procurar:");
                double gradeToFind = scanner.nextDouble();

                switch (searchChoice) {
                    case 1:
                        // Binary Search
                        Arrays.sort(grades);
                        startTime = System.nanoTime();
                        int binaryResult = binarySearch(grades, gradeToFind);
                        endTime = System.nanoTime();
                        System.out.println("Resultado da busca Binária: " + (binaryResult >= 0 ? "Encontrado no índice " + binaryResult : "Não encontrado"));
                        System.out.println("Tempo de execução (Binary Search): " + (endTime - startTime) + " nanosegundos");
                        break;
                    case 2:
                        // Interpolation Search
                        Arrays.sort(grades);
                        startTime = System.nanoTime();
                        int interpolationResult = interpolationSearch(grades, gradeToFind);
                        endTime = System.nanoTime();
                        System.out.println("Resultado da busca Interpolation: " + (interpolationResult >= 0 ? "Encontrado no índice " + interpolationResult : "Não encontrado"));
                        System.out.println("Tempo de execução (Interpolation Search): " + (endTime - startTime) + " nanosegundos");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    // Implementação do Bucket Sort
    public static void bucketSort(double[] arr) {
        int n = arr.length;
        if (n <= 1) return;

        // Encontre o valor máximo e mínimo para determinar o intervalo
        double min = arr[0], max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }

        // Criar os baldes
        int bucketCount = 10;
        double range = max - min;
        double bucketRange = range / bucketCount;
        double[][] buckets = new double[bucketCount][n];
        int[] bucketSizes = new int[bucketCount];

        // Distribuindo os elementos nos baldes
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) ((arr[i] - min) / bucketRange);
            if (bucketIndex == bucketCount) bucketIndex--; // Para valores máximos
            buckets[bucketIndex][bucketSizes[bucketIndex]++] = arr[i];
        }

        // Ordenando os baldes
        int index = 0;
        for (int i = 0; i < bucketCount; i++) {
            Arrays.sort(buckets[i], 0, bucketSizes[i]);
            for (int j = 0; j < bucketSizes[i]; j++) {
                arr[index++] = buckets[i][j];
            }
        }
    }

    // Implementação do Merge Sort
    public static void mergeSort(double[] arr, int left, int right) {
        if (left < right) {
            // Encontra o ponto médio da lista
            int mid = left + (right - left) / 2;

            // Recursivamente divide a lista em duas metades
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Une as duas metades ordenadas
            merge(arr, left, mid, right);
        }
    }

    // Função para mesclar as duas metades ordenadas
    public static void merge(double[] arr, int left, int mid, int right) {
        // Tamanhos das sublistas
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Arrays temporários para armazenar as duas metades
        double[] L = new double[n1];
        double[] R = new double[n2];

        // Copiar os dados para os arrays temporários
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        // Índices para as sublistas L, R e para o array original
        int i = 0, j = 0, k = left;

        // Mesclar as duas metades de volta no array original
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copiar os elementos restantes de L[] (se houver)
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copiar os elementos restantes de R[] (se houver)
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Implementação do Binary Search
    public static int binarySearch(double[] arr, double key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Verificar se o elemento foi encontrado
            if (arr[mid] == key) {
                return mid;
            }

            // Caso o elemento seja maior que o valor no meio
            if (arr[mid] < key) {
                low = mid + 1;
            }
            // Caso o elemento seja menor que o valor no meio
            else {
                high = mid - 1;
            }
        }
        return -1; // Caso o elemento não seja encontrado
    }

    // Implementação do Interpolation Search
    public static int interpolationSearch(double[] arr, double key) {
        int low = 0, high = arr.length - 1;

        while (low <= high && key >= arr[low] && key <= arr[high]) {
            // Estima a posição com base na fórmula do Interpolation Search
            int pos = low + (int) (((key - arr[low]) / (arr[high] - arr[low])) * (high - low));

            // Verifica se o elemento foi encontrado na posição estimada
            if (arr[pos] == key) {
                return pos;
            }

            if (arr[pos] < key) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
        return -1; // Caso o elemento não seja encontrado
    }
}