public class InsertionSort {
    public static void main(String[] args) {
        int[] A = {35, 95, 16, 33, 28, 76, 27, 10, 5};

        System.out.print("Початковий масив: ");
        printArray(A);

        insertionSort(A);

        System.out.print("Відсортований масив: ");
        printArray(A);
    }

    // Алгоритм сортування вставками
    public static void insertionSort(int[] A) {
        int n = A.length;

        // Перший елемент вважаемо відсортованим, починаємо зі второго.
        for (int i = 1; i < n; i++) {
            int key = A[i];   // Поточний елемент, який будемо вставляти
            int j = i - 1;

            // Зсуваємо елементи, що більші за key, вправо
            while (j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j = j - 1;
            }

            // Вставляємо key у правильне місце
            A[j + 1] = key;
        }
    }

    // Вивод масиву
    public static void printArray(int[] A) {
        for (int num : A) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}