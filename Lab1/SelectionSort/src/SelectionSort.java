public class SelectionSort {

    public static void main(String[] args) {
        int[] A = {35, 95, 16, 33, 28, 76, 27, 10, 5};

        System.out.print("Початковий масив: ");
        printArray(A);

        selectionSort(A);

        System.out.print("Відсортований масив: ");
        printArray(A);
    }

    // Метод сортування масиву методом вибору
    public static void selectionSort(int[] A) {
        int n = A.length; // Розмір масиву

        // Зовнішній цикл: ітеруємо по всіх елементах, крім останнього
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Припускаємо, що поточний елемент є мінімальним

            // Внутрішній цикл: шукаємо мінімальний елемент у невідсортованій частині масиву
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[minIndex]) {
                    minIndex = j; // Оновлюємо індекс мінімального елемента
                }
            }

            // Якщо мінімальний елемент не на своєму місці, міняємо їх місцями
            if (minIndex != i) {
                int temp = A[i];      // Тимчасово зберігаємо поточний елемент
                A[i] = A[minIndex];   // Ставимо мінімальний елемент на позицію i
                A[minIndex] = temp;   // На місце мінімального ставимо старий елемент
            }
        }
    }

    // Метод для виводу масиву на екран
    public static void printArray(int[] A) {
        for (int num : A) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}