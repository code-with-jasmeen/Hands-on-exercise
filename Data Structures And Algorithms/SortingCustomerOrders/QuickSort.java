package SortingCustomerOrders;

public class QuickSort
{
    public static void sort(Order[] arr, int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private static int partition(Order[] arr, int low, int high) {

        double pivot = arr[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j].totalPrice < pivot) {
                i++;

                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
