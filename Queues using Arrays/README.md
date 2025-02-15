Dynamic Queue Implementation

This folder contains the implementation of a Dynamic Queue using an array with a wrap-around mechanism in Java. The queue automatically resizes when it reaches full capacity, doubling its size to efficiently manage memory. The key operations—enqueue (adding an element to the queue) and dequeue (removing an element)—are designed to run in constant time (O(1)), except when resizing is necessary, which involves a time complexity of O(n).

Key Features:
- Dynamic Resizing: When the queue is full, it automatically doubles its capacity to accommodate more elements.
- Wrap-Around Mechanism: Efficient memory utilization is achieved by reusing the array space in a circular manner.
- Efficient Operations: Both enqueue and dequeue operations are executed in constant time, ensuring optimal performance for standard operations.
- Flexibility: The queue uses an Integer[] array, which allows for flexible handling of elements, including null values.

Code Breakdown:
- The queue maintains four integer variables: front, last, capacity, and size to track the status of the queue.
- enqueue(): Adds an element to the queue. If the queue is full, it triggers a resize.
- dequeue(): Removes and returns the front element from the queue.
- grow(): Resizes the underlying array when the queue exceeds its capacity.
- printInternal(): Displays the internal array of the queue.
- printQueue(): Displays the current elements in the queue.

The code demonstrates the use of the arrayQueue class by:
- Enqueuing elements into the queue, triggering resizing when necessary.
- Dequeuing elements and printing the queue’s internal state at each stage.
