import java.util.*;

public class ruff {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Operations op = new Operations();
        boolean a = true;
        while (a) {
            System.out.println("Enter the option number of the required operation:");
            int n = s.nextInt();
            switch (n) {
                case 0:
                    op.enqueue();
                    break;
                case 1:
                    op.dequeue();
                    break;
                case 2:
                    op.size();
                    break;
                case 3:
                    op.isEmpty();
                    break;
                case 4:
                    op.front();
                    break;
                case 5:
                    a = false;
                    break;
                default:
                    System.out.println("Choose a valid option");
            }
        }
    }
}

class Operations {
    int size;
    int arr[];
    int front;
    int rear;

    Operations() {
        arr = new int[2];
        front = 0;
        rear = 0;
    }

    void enqueue() {
        Scanner s = new Scanner(System.in);
        if (size == arr.length) {
            doubleSize();
        }
        System.out.println("Enter the value to be inserted:");
        int value = s.nextInt();
        arr[rear] = value;
        rear = (rear + 1) % arr.length; // Circular increment
        size++;
    }

    void dequeue() {
        if (size == 0) {
            System.out.println("Stack underflow");
            return;
        }
        System.out.println("Removed element is " + arr[front]);
        front = (front + 1) % arr.length; // Circular increment
        size--;
    }

    void size() {
        System.out.println(size);
    }

    void isEmpty() {
        System.out.println(size == 0);
    }

    void front() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(arr[front]);
    }

    void doubleSize() {
        int[] newArr = new int[size * 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[(front + i) % arr.length];
        }
        arr = newArr;
        front = 0;
        rear = size;
    }
}
