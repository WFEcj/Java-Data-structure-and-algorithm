package LinkBox;

public class Text {
	public static void main(String[] args) {
		LinkBox l=new LinkBox();
		l.add(10);
		l.add(11);
		int value=l.get(0);
		int value1=l.remove(0);
		System.out.println(value);
		System.out.println(value1);
		System.out.println(l.get(0));
	}
}
