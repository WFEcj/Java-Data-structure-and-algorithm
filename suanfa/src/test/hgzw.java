package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hgzw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String mes = in.nextLine();
		String[] res = mes.split(" ");
		int row = Integer.parseInt(res[0]);
		int col = Integer.parseInt(res[1]);
		int[] parent = new int[row*col];
		int[] rank = new int[row*col];
		Queue<int[]> session = new LinkedList<>();
		while(true) {
			mes = in.nextLine();
			if(mes.equals("")) break;
			res = mes.split(" ");
			if(res.length > 1) {
				int x = Integer.parseInt(res[0]);
				int y = Integer.parseInt(res[1]);
				if(Math.abs(y - x) == 1 || Math.abs(y - x) == col) session.offer(new int[] {x,y});
			}
		}
		initialise(parent,rank);
		while(!session.isEmpty()) {
			int[] val = session.poll();
			union_vertices(val[0],val[1],parent,rank);
		}
		int count = 0;
		for(int i = 0;i < row*col;i++) {
			if(parent[i] == -1) count++;
		}
		System.out.println(count);
	}
	private static void initialise(int[] parent,int[] rank) {
		for(int i = 0;i < parent.length;i++) {
			parent[i] = -1;
			rank[i] = 0;
		}
	}
	private static void union_vertices(int x,int y,int[] parent,int[] rank) {
		int x_root = find_root(x,parent);
		int y_root = find_root(y,parent);
		if(x_root != y_root) {
			if(rank[x_root] > rank[y_root]) {
				parent[y_root] = x_root;
			} else if(rank[x_root] < rank[y_root]){
				parent[x_root] = y_root;
			} else {
				parent[x_root] = y_root;
				rank[y_root]++;
			}
		}
	}
	private static int find_root(int x,int[] parent) {
		int x_root = x;
		while(parent[x_root] != -1) {
			x_root = parent[x_root];
		}
		return x_root;
	}
}
