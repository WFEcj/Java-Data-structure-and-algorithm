package queue2;

public class CircleQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleArrayQueue queue = new CircleArrayQueue(4);
		queue.addQueue(1);
		queue.addQueue(2);
		queue.addQueue(3);
//		queue.addQueue(4);
		System.out.println(queue.getQueue());
		System.out.println(queue.getQueue());
		System.out.println(queue.getQueue());
//		System.out.println(queue.getQueue());
	}
}
class CircleArrayQueue{
	int maxSize;
	int[] circleQueue;
	int front;
	int rear;
	public CircleArrayQueue() {
		maxSize = 16;
		circleQueue = new int[maxSize];
	}
	public CircleArrayQueue(int size) {
		maxSize = size;
		circleQueue = new int[maxSize];
	}
	public void addQueue(int n) {
		if(isFull()) {
			throw new RuntimeException("环形队列已满");
		}
		circleQueue[rear]=n;
		rear=(rear+1)%maxSize;
	}
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("环形队列为空");
		}
		int temp = circleQueue[front];
		front = (front + 1)%maxSize;
		return temp;
	}
	private boolean isFull() {
		return (rear+1)%maxSize==front;
	}
	private boolean isEmpty() {
		return front==rear;
	}
}