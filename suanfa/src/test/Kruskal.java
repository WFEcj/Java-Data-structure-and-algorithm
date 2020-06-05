package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kruskal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph = new int[][] {
			{0,15,6,0,0,25,0,0},
			{15,0,9,0,7,0,0,0},
			{6,9,0,11,0,0,0,0},
			{0,0,11,0,12,0,0,5},
			{0,7,0,12,0,5,0,7},
			{25,0,0,0,5,0,12,0},
			{0,0,0,0,0,12,0,17},
			{0,0,0,5,7,0,17,0},
		};
		ArrayList<Node> l = new ArrayList<>();
		int[] parent = new int[8];
		int[] rank = new int[8];
		initialise(parent,rank);
		getList(graph,l);
		Collections.sort(l);
		int edges = 0;
		while(edges != 7) {
			Node node = l.remove(0);
			//System.out.println(node);
			if(union_vertices(node.x,node.y,parent,rank) == 1) {
				System.out.println(node);
				edges++;
			}
		}
		//System.out.println(Arrays.toString(parent));
	}
	private static void initialise(int[] parent,int[] rank) {
		for(int i = 0;i < parent.length;i++) {
			parent[i] = -1;
			rank[i] = 0;
		}
	}
	private static int union_vertices(int x,int y,int[] parent,int[] rank) {
		int x_root = find_root(x,parent);
		int y_root = find_root(y,parent);
		if(x_root == y_root) {
			return 0;
		}else {
			if(rank[x_root] < rank[y_root]) {
				parent[x_root] = y_root;
			} else if(rank[x_root] > rank[y_root]) {
				parent[y_root] = x_root;
			} else {
				parent[y_root] = x_root;
				rank[x_root]++;
			}
			return 1;
		}
	}
	private static int find_root(int x,int[]parent) {
		int x_root = x;
		while(parent[x_root] != -1) {
			x_root = parent[x_root];
		}
		return x_root;
	}
	private static void getList(int[][] graph,List<Node> l) {
		int index = 0;
		for(int i = 0;i < graph.length;i++) {
			for(int j = index + 1;j<graph[0].length;j++) {
				if(graph[i][j] != 0) {
					l.add(new Node(i,j,graph[i][j]));
				}
			}
			index++;
		}
	}
}
class Node implements Comparable{
	int x,y;
	int weight;
	public Node(int x,int y,int weight){
		this.x = x;
		this.y = y;
		this.weight = weight;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Node) {
			Node node = (Node)o;
			return this.weight - node.weight;
		}
		throw new ClassCastException("无法转换为Node类型");
	}
	public String toString() {
		return "Node[x:"+this.x+",y:"+this.y+",weight:"+this.weight+"]";
	}
}
