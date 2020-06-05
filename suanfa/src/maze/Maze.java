package maze;

public class Maze {	
	public int count = 0;
	public String key ="";
	String[] map = new String[10];
	{
		map[0]="UDDLUULRUL";
		map[1]="UURLLLRRRU";
		map[2]="RRUURLDLRD";
		map[3]="RUDDDDUUUU";
		map[4]="URUDLLRRUU";
		map[5]="DURLRLDLRL";
		map[6]="ULLURLLRDU";
		map[7]="RDLULLRDDD";
		map[8]="UUDDUDUDLL";
		map[9]="ULRDLUURRR";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}
	public void solution(int i,int j) {
		if(i>9 || i<0 || j>9 || j<0) {
			count++;
			return;
		}
		for(int m = 0;m<9;m++) {
			for(int n=0;n<9;n++) {
				key = map[m].substring(n,n+1);
				if(key.equals("U")) {
					solution()
				}
			}
		}
	}
}
