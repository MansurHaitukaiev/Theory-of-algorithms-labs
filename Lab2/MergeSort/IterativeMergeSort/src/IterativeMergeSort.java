public class IterativeMergeSort {

    // лічильники базових операцій
    private static long comparisons = 0;  // кількість порівнянь
    private static long assignments = 0;  // кількість присвоєнь

    public static void mergeSortIterative(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];

        // width = розмір підмасивів (1, 2, 4, 8, ...)
        for (int width = 1; width < n; width *= 2) {
            for (int left = 0; left < n; left += 2 * width) {
                int mid = Math.min(left + width, n);
                int right = Math.min(left + 2 * width, n);

                merge(arr, temp, left, mid, right);
            }
            // копіюємо тимчасовий масив назад
            System.arraycopy(temp, 0, arr, 0, n);
            assignments += n; // копіювання елементів
        }
    }

    // злиття двох відсортованих підмасивів
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;  // покажчик лівого підмасиву
        int j = mid;   // покажчик правого підмасиву
        int k = left;  // покажчик тимчасового масиву

        while (i < mid && j < right) {
            comparisons++; // одне порівняння
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
            assignments++; // одне присвоєння у temp
        }

        // додаємо залишки з лівого підмасиву
        while (i < mid) {
            temp[k++] = arr[i++];
            assignments++;
        }

        // додаємо залишки з правого підмасиву
        while (j < right) {
            temp[k++] = arr[j++];
            assignments++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {35, 95, 16, 33, 28, 76, 27, 10, 5};

        System.out.println("Початковий масив:");
        printArray(arr);

        // обнулюємо лічильники
        comparisons = 0;
        assignments = 0;

        mergeSortIterative(arr);

        System.out.println("\nВідсортований масив:");
        printArray(arr);

        System.out.println("\nБазові операції:");
        System.out.println("Порівнянь: " + comparisons);
        System.out.println("Присвоєнь: " + assignments);
        System.out.println("Сумарно: " + (comparisons + assignments));
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}