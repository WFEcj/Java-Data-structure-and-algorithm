package queue;

public class CircleQueue {
	private int[] circleQueue;
	private int front;//指向第一个数
	private int real;//指向last后一个元素
	private int maxSize;
	public CircleQueue(int maxSize) {
		this.maxSize=maxSize;
		circleQueue = new int[maxSize];
	}
	public void add(int value) {
		if(this.isFull()) {
			System.out.println("数组已满、无法添加！");
			return;
		}
		circleQueue[real]=value;
		real=(real+1)%maxSize;
	}
	public int get() {
		if(this.isEmpty()) {
			throw new RuntimeException("数组为空、无法取出元素！！");
		}
		int value = circleQueue[front];
		front=(front+1)%maxSize;
		return value;
	}
	public int head() {
		if(this.isEmpty()) {
			throw new RuntimeException("数组为空！！");
		}
		return circleQueue[front];
	}
	public void showCircleQueue() {
		if(this.isEmpty()) {
			System.out.println("数组为空！");
			return;
		}
		for(int i = front;i<front+(real-front+maxSize)%maxSize;i++) {
			System.out.printf("circleQueue[%d]=%d",i%maxSize,circleQueue[i%maxSize]);
			System.out.println();
		}
		System.out.println();
	}
	private boolean isFull() {
		return (real+1)%maxSize==front;
	}
	private boolean isEmpty() {
		return front==real;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleQueue cq = new CircleQueue(4);
		cq.add(1);
		cq.showCircleQueue();
		cq.add(2);
		cq.showCircleQueue();
		cq.add(3);
		cq.showCircleQueue();
		//queue.add(6);
		System.out.println(cq.get());
		System.out.println(cq.get());
		cq.showCircleQueue();
		cq.add(3);
		cq.add(3);
		cq.showCircleQueue();
		System.out.println(cq.get());
	}

}
