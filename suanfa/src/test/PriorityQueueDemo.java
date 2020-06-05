package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparator<Integer> cmp = new Comparator<Integer>() {
			public int compare(Integer t1,Integer t2) {
				return t2 - t1;
			}
		};
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>((t1,t2) -> t2 - t1);
		maxQueue.offer(5);
		maxQueue.offer(3);
		maxQueue.offer(6);
		maxQueue.offer(2);
		maxQueue.offer(9);
		while(!maxQueue.isEmpty()) {
			System.out.println(maxQueue.poll());
		}
	}

}
