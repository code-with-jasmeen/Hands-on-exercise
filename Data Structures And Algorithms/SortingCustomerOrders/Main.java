package SortingCustomerOrders;

public class Main
{
    public static void main(String[] args) {

        Order[] orders = {
                new Order(101, "Aman", 500),
                new Order(102, "Neha", 1500),
                new Order(103, "Raj", 800),
                new Order(104, "Simran", 2000)
        };

        // Bubble Sort
        Order[] bubbleArr = orders.clone();
        BubbleSort.sort(bubbleArr);

        System.out.println("Bubble Sort Result:");
        for (Order o : bubbleArr) {
            System.out.println(o);
        }

        // Quick Sort
        Order[] quickArr = orders.clone();
        QuickSort.sort(quickArr, 0, quickArr.length - 1);

        System.out.println("\nQuick Sort Result:");
        for (Order o : quickArr) {
            System.out.println(o);
        }
    }}
