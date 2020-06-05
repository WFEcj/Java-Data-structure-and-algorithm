package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KeyPass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertex2[] graph = new Vertex2[10];
		Stack<Vertex2> s = new Stack<>();
		Stack<Vertex2> s1 = new Stack<>();
		List<Integer> res = new ArrayList<>();
		int[] etv = new int[10];
		int[] ltv = new int[10];
		initialise(graph);
		for(Vertex2 v : graph) {
			if(v.in == 0) s.push(v);
		}
		while(!s.isEmpty()) {
			Vertex2 v = s.pop();
			s1.push(v);
			res.add(v.data);
			Edge2 cur = v.head;
			while(cur != null) {
				graph[cur.adjvex].in--;
				if(graph[cur.adjvex].in == 0) s.push(graph[cur.adjvex]);
				if(etv[v.data] + cur.weight > etv[cur.adjvex])
					etv[cur.adjvex] = etv[v.data] + cur.weight;
				cur = cur.next;
			}
		}
		if(res.size() < graph.length) {
			System.out.println("存在环");
		} else {
			for(Integer i : res) {
				System.out.print(i + "->");
			}
		}
		System.out.println();
		System.out.println(Arrays.toString(etv));
		Arrays.fill(ltv, etv[etv.length - 1]);
		while(!s1.isEmpty()) {
			Vertex2 v = s1.pop();
			Edge2 cur = v.head;
			while(cur != null) {
				if(ltv[cur.adjvex] - cur.weight < ltv[v.data])
					ltv[v.data] = ltv[cur.adjvex] - cur.weight;
				cur = cur.next;
			}
		}
		System.out.println(Arrays.toString(ltv));
	}
	private static void initialise(Vertex2[] graph) {
		for(int i = 0; i < graph.length;i++) {
			graph[i] = new Vertex2(i);
		}
		graph[0].add(4,2).add(3,1);
		graph[1].add(6,4).add(5,3);
		graph[2].add(7,5).add(8,3);
		graph[3].add(3,4);
		graph[4].add(4,7).add(9,6);
		graph[5].add(6,7);
		graph[6].add(2,9);
		graph[7].add(5,8);
		graph[8].add(3,9);
		for(int i = 0;i < graph.length;i++) {
			Edge2 cur = graph[i].head;
			while(cur != null) {
				graph[cur.adjvex].in++;
				cur = cur.next;
			}
		}
	}
}
class Vertex2{
	int in;
	int data;
	Edge2 head;
	Edge2 tail;
	public Vertex2(int data) {
		this.data = data;
	}
	public Vertex2 add(int adjvex) {
		if(head == null) {
			this.head = new Edge2(adjvex);
			this.tail = head;
			return this;
		}
		Edge2 e = new Edge2(adjvex);
		this.tail.next = e;
		this.tail = e;
		return this;
	}
	public Vertex2 add(int weight,int adjvex) {
		if(head == null) {
			this.head = new Edge2(weight,adjvex);
			this.tail = head;
			return this;
		}
		Edge2 e = new Edge2(weight,adjvex);
		this.tail.next = e;
		this.tail = e;
		return this;
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		Edge2 cur = this.head;
		while(cur != null) {
			str.append("->");
			str.append(cur.adjvex);
			cur = cur.next;
		}
		return this.in +"-" + this.data + str.toString();
	}
}
class Edge2{
	int adjvex;
	int weight;
	Edge2 next;
	public Edge2(int adjvex) {
		this.adjvex = adjvex;
	}
	public Edge2(int weight,int adjvex) {
		this.weight = weight;
		this.adjvex = adjvex;
	}
}
