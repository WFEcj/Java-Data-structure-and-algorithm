package Calculation;

public class Test {
	public static void main(String[] args) {
		Add add=new Add(2,3);
		System.out.println(add.x+"+"+add.y+"="+add.getSum());
		Sub sub=new Sub(8,2);
		System.out.println(sub.x+"+"+sub.y+"="+sub.getDif());
	}
}
