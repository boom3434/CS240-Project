package platformer.entities.creatures;

class Queue {
	private int[] arr;
	private int front;
	private int rear;
	private int capacity;
	private int count;

	Queue(int size) {
		arr = new int[size];
		capacity = size;
		front = 0;
		rear = -1;
		count = 0;
	}

	public void dequeue() {
		if (isEmpty()) {
			System.out.println("Underflow");
			System.exit(1);
		}

		front = (front + 1) % capacity;
		count--;
	}

	public void enqueue(int item) {
		if (isFull()) {
			System.out.println("Too many elements for size!");
			System.out.println("Terminating...");
			System.exit(1);
		}

		rear = (rear + 1) % capacity;
		arr[rear] = item;
		count++;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
			System.out.println("Terminating...");
			System.exit(1);
		}
		return arr[front];
	}

	public int size() {
		return count;
	}

	public Boolean isEmpty() {
		return (size() == 0);
	}

	private Boolean isFull() {
		return (size() == capacity);
	}
}
