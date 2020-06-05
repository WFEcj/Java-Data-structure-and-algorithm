package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] dirs = {{1,0},{2,0},{1,5},{5,3}};
//		for(int[] v : dirs) {
//			System.out.println(Arrays.toString(v));
//		}
		Queue<int[]> q = new LinkedList<>();
		//q.offer(new int[]{1,2});
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
		int[] visited = new int[8];
		int[][] res = new int[3][8];
		Arrays.fill(res[1], Integer.MAX_VALUE);
		Arrays.fill(res[0], -1);
		Arrays.fill(res[2], -1);
		helper(graph,res,visited,0);
		System.out.print(Arrays.toString(res[2]));
	}
	private static void helper(int[][] graph,int[][] res,int[] visited,int target) {
		int count = 1  ;
		while(count != 8) {
			visited[target] = 1;
			for(int j = 0;j < 8;j++) {
				if(graph[target][j] == 0 || visited[j] == 1) continue;
				if(res[1][j] > graph[target][j]) {
					 res[1][j] = graph[target][j];
					 res[0][j] = target;
				}
			}
			int index = find_min(res,visited);
			res[2][index] = res[0][index];
			target = index;
			count++;
		}
	}
	private static int find_min(int[][] res,int[] visited) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int i = 0;i < 8;i++) {
			if(visited[i] == 1) continue;
			if(min > res[1][i]) {
				min = res[1][i];
				index = i;
			}
		}
		return index;
	}
}
