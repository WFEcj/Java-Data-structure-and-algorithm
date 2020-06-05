package queue2;

public class Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayQueue a = new ArrayQueue(3);
		a.addQueue(5);
		a.addQueue(6);
		a.addQueue(7);
//		a.addQueue(7);
		System.out.println(a.getQueue());
		System.out.println(a.getQueue());
		System.out.println(a.getQueue());
//		System.out.println(a.getQueue());
	}
	
}
class ArrayQueue{
	int maxSize;
	int[] queue;
	int front;//指向第一个的前一位
	int rear;//指向最后一位
	public ArrayQueue() {
		this.maxSize = 16;
		queue = new int[maxSize];
		front = -1;
		rear = -1;
	}
	public ArrayQueue(int size) {
		this.maxSize = size;
		queue = new int[maxSize];
		front = -1;
		rear = -1;
	}
	public void addQueue(int n) {
		if(isFull()) {
			throw new RuntimeException("队列已满");
		}
		rear++;
		queue[rear] = n;
	}
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		front++;
		return queue[front];
	}
	private boolean isEmpty() {
		return front==rear;
	}
	private boolean isFull() {
		return rear==maxSize-1;
	}
}
