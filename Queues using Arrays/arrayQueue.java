package ArraysQueues;

public class arrayQueue {
    Integer[] array;      //Array to store queue elements
    int front;      //Index of the front element
    int last;       //Index of the last  element
    int capacity;   //Maximum number of elements in teh queue
    int size;       //Current number of elements in the queue


    //Constructor to initialize the queue
    public arrayQueue(int capacity){
        this.capacity = capacity;
        array = new Integer[capacity];    //an array with capacity(length) of n
        front = 0;   //k = front = first element of the queue = keeping track of the first element in the queue
        last = -1;   //k - 1
        size = 0;
    }

    public int growRatio = 2;

    public void enqueue(int item){
        if(size == capacity){  //if the queue is full
            grow(capacity * growRatio);   //double the capacity if the queue is full
        }
        last = nextIndex(last);  //circular increment
        array[last] = item;
        size++;
    }

    private int nextIndex(int current_index) {
        //when front k is equal to n-1 the last element
        return (current_index + 1) % capacity;
    }

    public int dequeue(){
        if(size == 0){
            System.out.println("Queue is empty. Cannot dequeue");
            return -1;
        }
        int item = array[front];
        array[front] = null;
        front = nextIndex(front);
        size--;

        return item;
    }


    private void grow(int newCapacity){
        if(newCapacity <= capacity){
            return;
        }
        Integer[] newArray = new Integer[newCapacity];
        int y = 0;
        for(int i = front; y < size; i = nextIndex(i)) {
            newArray[y] = array[i];
            y++;
        }
        array = newArray;
        front = 0;   //reset front
        last = size - 1;  //reset last
        capacity = newCapacity;  //update capacity
    }


    public void printInternal() {
        System.out.print("Queue internal: [");
        for(int i = 0; i < capacity; i++) {
            System.out.print(array[i]);
            if(i != capacity - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void printQueue() {
        System.out.print("Queue: [");
        int y = 0;
        for(int i = front; y < size; i = nextIndex(i)) {
            System.out.print(array[i]);
            if(y != size - 1) {
                System.out.print(", ");
            }
            y++;
        }
        System.out.println("]");
    }




    public static void main(String[] args) {
        arrayQueue queue = new arrayQueue(2); // Create a queue with initial capacity 2

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30); // Triggers resizing
        queue.enqueue(40);

        queue.printInternal();
        queue.printQueue();

        queue.dequeue();
        queue.dequeue();

        queue.printInternal();
        queue.printQueue();
        queue.enqueue(50);
        queue.enqueue(60);
        queue.printInternal();
        queue.printQueue();
    }
}
