package ArrayBox;

public class Test {
	public static void main(String[] args) {
		ArrayBox<Integer> box = new ArrayBox<Integer>();
		for(int i =1;i<=11;i++) {
			box.add(i*10);
		}
		System.out.println("size:"+box.getSize());
		System.out.println("length:"+box.getArray().length);
		int value=box.get(9);
		System.out.println(value);
		for(int i=0;i<box.getSize();i++) {
			System.out.print(box.get(i)+" ");
		}
		box.remove(1);
		System.out.println();
		for(int i=0;i<box.getSize();i++) {
			System.out.print(box.get(i)+" ");
		}
		System.out.println(box.get(50));
	}
}
