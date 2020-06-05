package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TuoPu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertex[] graph = new Vertex[14];
		Stack<Vertex> s = new Stack<>();
		List<Integer> res = new ArrayList<>();
		initialise(graph);
		for(Vertex v : graph) {
			if(v.in == 0) s.push(v);
		}
		while(!s.isEmpty()) {
			Vertex v = s.pop();
			res.add(v.data);
			Edge cur = v.head;
			while(cur != null) {
				graph[cur.adjvex].in--;
				if(graph[cur.adjvex].in == 0) s.push(graph[cur.adjvex]);
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
	}
	private static void initialise(Vertex[] graph) {
		for(int i = 0; i < graph.length;i++) {
			graph[i] = new Vertex(i);
		}
		graph[0].add(11).add(5).add(4);
		graph[1].add(8).add(4).add(2);
		graph[2].add(9).add(6).add(5);
		graph[3].add(13).add(2);
		graph[4].add(7);
		graph[5].add(12).add(8);
		graph[6].add(5);
		graph[8].add(7);
		graph[9].add(11).add(10);
		graph[10].add(13);
		graph[12].add(9);
		for(int i = 0;i < graph.length;i++) {
			Edge cur = graph[i].head;
			while(cur != null) {
				graph[cur.adjvex].in++;
				cur = cur.next;
			}
		}
	}
}
class Vertex{
	int in;
	int data;
	Edge head;
	Edge tail;
	public Vertex(int data) {
		this.data = data;
	}
	public Vertex add(int adjvex) {
		if(head == null) {
			this.head = new Edge(adjvex);
			this.tail = head;
			return this;
		}
		Edge e = new Edge(adjvex);
		this.tail.next = e;
		this.tail = e;
		return this;
	}
	public void add(int weight,int adjvex) {
		if(head == null) {
			this.head = new Edge(weight,adjvex);
			return;
		}
		Edge e = new Edge(weight,adjvex);
		this.tail.next = e;
		this.tail = e;
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		Edge cur = this.head;
		while(cur != null) {
			str.append("->");
			str.append(cur.adjvex);
			cur = cur.next;
		}
		return this.in +"-" + this.data + str.toString();
	}
}
class Edge{
	int adjvex;
	int weight;
	Edge next;
	public Edge(int adjvex) {
		this.adjvex = adjvex;
	}
	public Edge(int weight,int adjvex) {
		this.weight = weight;
		this.adjvex = adjvex;
	}
}
