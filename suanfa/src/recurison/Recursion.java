package recurison;

public class Recursion {
	private int[][] map = new int[8][7];
	{
		for(int i =0;i<8;i++) {
			map[i][0]=1;
			map[i][6]=1;
		}
		for(int j=0;j<7;j++) {
			map[0][j]=1;
			map[7][j]=1;
		}
		map[3][1]=1;
		map[3][2]=1;
	}
	public int[][] getMap(){
		return map;
	}
	public boolean solution(int[][] map,int i,int j) {
		if(map[i][j]==0) {
			map[i][j]=2;
			if(map[6][5]==2) {
				return true;
			}else if(solution(map,i+1,j)) {
				return true;
			}else if(solution(map,i,j+1)) {
				return true;
			}else if(solution(map,i-1,j)) {
				return true;
			}else if(solution(map,i,j-1)) {
				return true;
			}else {
				map[i][j]=3;
				return false;
			}
		}else {
			return false;
		}
	}
	public void print(int[][] map) {
		for(int i=0;i<8;i++) {
			for(int j=0;j<7;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Recursion r = new Recursion();
		int[][] map=r.getMap();
		r.print(map);
		System.out.println();
		r.solution(map,1, 1);
		r.print(map);
	}
}
