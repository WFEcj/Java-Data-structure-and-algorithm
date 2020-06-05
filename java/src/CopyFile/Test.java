package CopyFile;

import java.io.File;

public class Test {
	public static void main(String[] args) {
		CopyFile cf = new CopyFile();
		File file = new File("E:\\aaa");
		//cf.showFile(file);
		cf.copy(file, "D:\\");
	}
}
