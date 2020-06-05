package test;

import java.util.Arrays;

public class Floyd {
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
		int m = graph.length;
		int[][] dis = new int[m][m];
		int[][] par = new int[m][m];
		initialise(dis,par,graph);
		for(int k = 0;k < m;k++) {
			for(int i = 0;i < m;i++) {
				for(int j = 0;j < m;j++) {
					if(i == j) continue;
					if(dis[i][j] > dis[i][k] + dis[k][j]) {
						dis[i][j] = dis[i][k] + dis[k][j];
						par[i][j] = par[k][j];
					}
				}
			}
		}
		for(int[] arr : dis) {
			System.out.println(Arrays.toString(arr));
		}
		for(int[] arr : par) {
			System.out.println(Arrays.toString(arr));
		}
	}
	private static void initialise(int[][] dis,int[][] par,int[][] graph) {
		int N = 65535;
		for(int i = 0;i < dis.length; i++) {
			Arrays.fill(par[i], i);
			for(int j = 0;j < dis[0].length;j++) {
				if(i == j) continue;
				if(graph[i][j] == 0) {
					dis[i][j] = N;
				} else {
					dis[i][j] = graph[i][j];
				}
			}
		}
	}
}
