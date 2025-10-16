class RecursiveMergeSort {

    // лічильники базових операцій
    static long comparisons = 0;       // кількість порівнянь
    static long assignments = 0;       // кількість присвоєнь
    static long recursiveCalls = 0;    // кількість рекурсивних викликів

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        recursiveCalls++; // кожен виклик функції

        if (left >= right) return; // базовий випадок

        int mid = left + (right - left) / 2;

        // рекурсивно сортуємо ліву і праву частини
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // злиття двох частин
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // копіювання у тимчасові масиви
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
            assignments++;
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
            assignments++;
        }

        int i = 0, j = 0, k = left;

        // злиття двох відсортованих частин
        while (i < n1 && j < n2) {
            comparisons++; // порівняння L[i] і R[j]
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
            assignments++; // запис у arr[k]
        }

        // копіювання залишків з L
        while (i < n1) {
            arr[k++] = L[i++];
            assignments++;
        }

        // копіювання залишків з R
        while (j < n2) {
            arr[k++] = R[j++];
            assignments++;
        }
    }

    // вивід масиву
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // тестування
    public static void main(String[] args) {
        int[] arr = {35, 95, 16, 33, 28, 76, 27, 10, 5};

        System.out.println("Початковий масив:");
        printArray(arr);

        comparisons = 0;
        assignments = 0;
        recursiveCalls = 0;

        mergeSort(arr);

        System.out.println("\nВідсортований масив:");
        printArray(arr);

        System.out.println("\nБазові операції:");
        System.out.println("Порівнянь: " + comparisons);
        System.out.println("Присвоєнь: " + assignments);
        System.out.println("Сумарно: " + (comparisons + assignments));
        System.out.println("Рекурсивних викликів: " + recursiveCalls);
    }
}