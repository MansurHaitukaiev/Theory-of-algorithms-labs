public class QuickSort {

    static long comparisons = 0;
    static long assignments = 0;
    static long recursiveCalls = 0;

    public static void quickSort(int[] a) {
        if (a == null || a.length < 2) return;
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int l, int r) {
        recursiveCalls++;
        if (l >= r) return;

        int q = partitionHoare(a, l, r);
        assignments++;

        quickSort(a, l, q);
        quickSort(a, q + 1, r);
    }

    private static int partitionHoare(int[] a, int l, int r) {
        int pivot = a[l];  assignments++;
        int i = l - 1;     assignments++;
        int j = r + 1;     assignments++;

        while (true) {
            do {
                i++; assignments++;
                comparisons++;
            } while (a[i] < pivot);

            do {
                j--; assignments++;
                comparisons++;
            } while (a[j] > pivot);

            comparisons++;
            if (i >= j) return j;

            swap(a, i, j);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i]; assignments++;
        a[i] = a[j]; assignments++;
        a[j] = t;   assignments++;
    }

    private static void print(int[] a) {
        for (int v : a) System.out.print(v + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {35, 95, 16, 33, 28, 76, 27, 10, 5};

        System.out.println("Початковий масив:");
        print(arr);

        comparisons = assignments = recursiveCalls = 0;

        quickSort(arr);

        System.out.println("\nВідсортований масив:");
        print(arr);

        System.out.println("\nБазові операції:");
        System.out.println("Порівнянь: " + comparisons);
        System.out.println("Присвоєнь: " + assignments);
        System.out.println("Сумарно: " + (comparisons + assignments));
        System.out.println("Рекурсивних викликів: " + recursiveCalls);
    }
}