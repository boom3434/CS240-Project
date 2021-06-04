//Finn Parker - Jonathan Steger - Bryce Johnston
//CS240 Project
//Instructor: Ryan Parsons
//our own implementation of a queue for the game

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
			System.out.println("The queue is already empty!!");
		}

		front = (front + 1) % capacity;
		count--;
	}

	public void enqueue(int item) {
		if (isFull()) {
			System.out.println("Too many elements for size!");
		}

		rear = (rear + 1) % capacity;
		arr[rear] = item;
		count++;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
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
