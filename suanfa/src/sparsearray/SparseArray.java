package sparsearray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SparseArray {
	public int[][] arrToSparse(int[][] chessArr) {
		int sum ;
		int count = 0;
		sum = this.getSum(chessArr);
		int[][] sparseArr = new int[sum+1][3];
		sparseArr[0][0]=11;
		sparseArr[0][1]=11;
		sparseArr[0][2]=sum;
		for(int i =0;i<11;i++) {
			for(int j =0;j<11;j++) {
				if(chessArr[i][j]!=0) {
					count++;
					sparseArr[count][0]=i;
					sparseArr[count][1]=j;
					sparseArr[count][2]=chessArr[i][j];
				}
			}
		}
		return sparseArr;
	}
	public void showArr(int[][] arr) {
		for(int[] arrSon:arr) {
			for(int value:arrSon) {
				System.out.printf("%d\t",value);
			}
			System.out.println();
		}
	}
	public void saveSparseArr(int[][] sparseArr) {
		FileWriter fos = null;
		try {
			fos = new FileWriter("E:\\aaa\\innerA.txt");
			for(int[] arr:sparseArr) {
				for(int value:arr) {
					fos.write(String.valueOf(value)+"\t");
				}
				fos.write("\r\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(fos!=null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	public int[][] getSparseArray(){
		FileReader fr = null;
		BufferedReader br =null;
		int[][] sparseArray = null;
		int count = 0;
		try {
			fr = new FileReader("E:\\aaa\\innerA.txt");
			br = new BufferedReader(fr);
			String message = br.readLine();
			StringBuilder str = new StringBuilder();
			while(message!=null) {
				count++;
				str.append(message);
				str.append(",");
				message = br.readLine();
			}
			sparseArray = new int[count][3];
			String[] messages = str.toString().split(",");
			for(int i =0;i<messages.length;i++) {
				if(messages[i]!=null) {
					String[] num = messages[i].split("\t");
					sparseArray[i][0]=Integer.parseInt(num[0]);
					sparseArray[i][1]=Integer.parseInt(num[1]);
					sparseArray[i][2]=Integer.parseInt(num[2]);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(fr!=null) {
					fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(br!=null) {
					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sparseArray;
	}
	private int getSum(int[][] chessArr) {
		int sum=0;
		for(int[] arr:chessArr) {
			for(int value:arr) {
				if(value!=0) {
					sum++;
				}
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SparseArray sa = new SparseArray();
		int[][] chessArr = new int[11][11];
		chessArr[1][2]=1;
		chessArr[2][3]=2;
		int[][] sparseArr = sa.arrToSparse(chessArr);
		sa.showArr(chessArr);
		sa.showArr(sparseArr);
		//sa.saveSparseArr(sparseArr);
		int[][] sparseArray1=sa.getSparseArray();
		sa.showArr(sparseArray1);
	}
}
