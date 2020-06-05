package queue;

public class Queue {
	private int maxSize;
	private int[] queue;
	private int front;
	private int real;
	public Queue(int maxSize) {
		this.maxSize=maxSize;
		queue = new int[maxSize];
		this.front=-1;//ָ
		this.real=-1;//
	}
	public void add(int value) {
		if(this.isFull()) {
			System.out.println("�����������޷���ӣ�");
			return;
		}
		real++;
		queue[real]=value;
	}
	public int get() {
		if(this.isEmpty()) {
			throw new RuntimeException("����Ϊ�ա��޷�ȡ������");
		}
		front++;
		return queue[front];
	}
	public int head() {
		if(this.isEmpty()) {
			throw new RuntimeException("����Ϊ�ա��޷��鿴����");
		}
		return queue[front+1];
	}
	public void showQueue() {
		if(this.isEmpty()) {
			System.out.println("����Ϊ�գ�");
		}else {
			for(int i =0;i<maxSize;i++) {
				System.out.printf("queue[%d]=%d",i,queue[i]);
				System.out.println();
			}
		}
	}
	private boolean isFull() {
		return real==maxSize-1;
	}
	private boolean isEmpty() {
		return front==real;
	}
	public static void main(String[] args) {
		Queue queue = new Queue(3);
		queue.add(1);
		queue.showQueue();
		queue.add(2);
		queue.showQueue();
		queue.add(3);
		queue.showQueue();
		System.out.println(queue.head());
		//queue.add(6);
		System.out.println(queue.get());
		System.out.println(queue.get());
		System.out.println(queue.get());
		queue.showQueue();
	}
}
