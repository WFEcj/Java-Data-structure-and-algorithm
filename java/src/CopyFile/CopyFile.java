package CopyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
	public void showFile(File file) {
		File[] files = file.listFiles();
		if(files!=null && files.length!=0) {
			for(File f:files) {
				this.showFile(f);
			}
		}
		System.out.println(file.getAbsolutePath());
	}
	public void copy(File sourceFile,String moveTo) { 
		File[] files = sourceFile.listFiles();
		String oldPath = sourceFile.getAbsolutePath().split(":")[1];
		String newPath = moveTo+oldPath;
		File targetFile = new File(newPath);
		if(files!=null) {
			targetFile.mkdir();
			if(files.length!=0) {
				for(File f:files) {
					this.copy(f, moveTo);
				}
			}
		}else {
			FileInputStream fis = null;
			FileOutputStream fos =null;
			try {
				fis = new FileInputStream(sourceFile);
				fos = new FileOutputStream(targetFile);
				byte[] b =new byte[1024];
				int count = fis.read(b);
				while(count!=-1) {
					fos.write(b, 0, count);
					fos.flush();
					count = fis.read();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(fis!=null) {
						fis.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
	}
	public void delete(File file) {
		File[] files = file.listFiles();
		if(files!=null && files.length!=0) {
			for(File f:files) {
				this.delete(f);
			}
		}
		file.delete();
	}
}
