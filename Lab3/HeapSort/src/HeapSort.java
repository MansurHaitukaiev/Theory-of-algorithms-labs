public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // фаза 1: побудова максимальної купи Heap_Max(A), починаємо з останнього внутрішнього вузла: floor(n/2) - 1
        for (int i = n / 2 - 1; i >= 0; i--) {
            sink(arr, i, n);
        }

        // фаза 2: сортування, послідовно вилучаємо максимальний елемент і переміщуємо його в кінець масиву
        for (int i = n - 1; i > 0; i--) {
            // обмін (Swap): A[0] (корінь, найбільший елемент) з A[i] (останній елемент купи)
            swap(arr, 0, i);

            // відновлюємо властивості купи для зменшеного масиву
            // новий розмір купи: i
            sink(arr, 0, i);
        }
    }

     // процедура занурення Sink для відновлення властивості максимальної купи
    private static void sink(int[] arr, int i, int n) {
        int k = i; // поточний індекс елемента, що занурюється

        while (true) {
            int leftChild = 2 * k + 1;  // індекс лівого нащадка

            // перевірка на існування лівого нащадка (чи k не є листом)
            if (leftChild >= n) {
                break;
            }

            int largest = leftChild; // припускаємо, що лівий нащадок найбільший

            int rightChild = 2 * k + 2; // індекс правого нащадка

            // знаходимо індекс найбільшого нащадка
            if (rightChild < n && arr[rightChild] > arr[leftChild]) {
                largest = rightChild;
            }

            // порівнюємо поточний елемент з найбільшим нащадком
            if (arr[k] >= arr[largest]) {
                break; // елемент на своєму місці
            }

            // обмін і перехід на рівень нижче
            swap(arr, k, largest); // обмінюємо arr[k] з найбільшим нащадком arr[largest]
            k = largest;             // продовжуємо занурення з нової позиції
        }
    }

    //допоміжний метод для обміну двох елементів у масиві
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {35, 95, 16, 33, 28, 76, 27, 10, 5};
        System.out.println("Масив до сортування: " + java.util.Arrays.toString(array));

        heapSort(array);

        System.out.println("Масив після сортування: " + java.util.Arrays.toString(array));
    }
}