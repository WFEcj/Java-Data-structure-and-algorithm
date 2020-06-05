package sparsearray2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class SparseArray {
	public static void main(String[] args) {
		int[][] a = new int[10][10];
		a[1][2]=12;
		a[1][3]=9;
		a[3][1]=-3;
		a[3][6]=14;
		a[4][3]=24;
		a[5][2]=18;
		a[6][1]=15;
		a[6][4]=-7;
		show(a);
		int[][] b = getSparseArray(a);
		show(b);
		transposition(b);
//		saveSparseArray(b,"E:\\aaa\\innerA.txt");
//		int[][] c = getSparseArrayFromFile("E:\\aaa\\innerA.txt");
//		show(c);
	}
	public static void show(int[][] a) {
		for(int[] b:a) {
			for(int c:b) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}
	private static int getNumber(int[][] a) {
		int count = 0;
		for(int[] b:a) {
			for(int c:b) {
				if(c!=0) {
					count++;
				}
			}
		}
		return count;
	}
	public static int[][] getSparseArray(int[][] a){
		int n = getNumber(a);
		int count = 1;
		int[][] sparseArray = new int[n+1][3];
		sparseArray[0][0]=a.length;
		sparseArray[0][1]=a[0].length;
		sparseArray[0][2]=n;
		for(int i = 1;i<a.length;i++) {
			for(int j =1;j<a[i].length;j++) {
				if(a[i-1][j-1]!=0) {
					sparseArray[count][0]=i;
					sparseArray[count][1]=j;
					sparseArray[count][2]=a[i-1][j-1];
					count++;
				}
			}
		}
		return sparseArray;
	}
	public static void saveSparseArray(int[][] a,String path) {
		OutputStream os =null;
		ObjectOutputStream oos = null;
		try {
			os = new FileOutputStream(path);
			oos = new ObjectOutputStream(os);
			oos.writeObject(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static int[][] getSparseArrayFromFile(String path) {
		InputStream is = null;
		int[][] a = null;
		ObjectInputStream ois = null;
		try {
			is = new FileInputStream(path);
			ois = new ObjectInputStream(is);
			a = (int[][])ois.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return a;
	}
	public static int[][] transposition(int[][] sparseArray) {
		//sparseArray[0][0] 与sparseArray[0][1] 分别表示原矩阵行列数
		int len = sparseArray.length;
		int[][] res = new int[len][3];
		int[] num = new int[sparseArray[0][1]];
		int[] location = new int[sparseArray[0][1]];
		for(int i = 1;i < len; i++) {
			num[sparseArray[i][1]]++;
		}
		location[1] = 1;
		for(int i = 2;i < sparseArray[0][1]; i++) {
			location[i] = location[i - 1] + num[i - 1];
		}
		//print(num);
		//print(location);
		res[0][0] = sparseArray[0][0];
		res[0][1] = sparseArray[0][1];
		res[0][2] = sparseArray[0][2];
		for(int i = 1; i < len; i++) {
			res[location[sparseArray[i][1]]][0] = sparseArray[i][1];
			res[location[sparseArray[i][1]]][1] = sparseArray[i][0];
			res[location[sparseArray[i][1]]][2] = sparseArray[i][2];
			location[sparseArray[i][1]]++;
		}
		//show(res);
		return res;
	}
	public static void print(int[] arr) {
		for(int v : arr) {
			System.out.print(v+" ");
		}
		System.out.println();
	}
}
